! function(angular, window, b) {
    var app = angular.module('myApp', ['ngRoute']);

    app.directive("navbar", function() {
        return {
            restrict: "E",
            templateUrl: './public/template/nav.html',
            replace: true
        }
    });
    app.directive("foot", function() {
        return {
            restrict: "E",
            templateUrl: './public/template/footerTpl.html',
            replace: true
        }
    });
    app.service("setPage", function() {
        return {
            init: function(pages, callback) {

                var lastPage = document.getElementById("lastPage");
                var fNode = document.getElementById("ul");
                for (var i = 1; i <= pages; i++) {
                    var newNode = document.createElement("li");
                    var AElement = document.createElement("a");
                    var textnode = document.createTextNode(i);
                    AElement.appendChild(textnode);
                    newNode.appendChild(AElement);
                    newNode.addEventListener("click", function() {

                        var index = i;
                        return function() {
                            callback(index);
                        }
                    }())
                    fNode.insertBefore(newNode, lastPage);

                }

            }
        }
    })

    app.config(['$routeProvider', function($routeProvider) {
        $routeProvider.when("/index", {
            templateUrl: "./public/template/indexTpl.html",
            controller: "indexController"
        }).when("/personalCenter", {
            templateUrl: "./public/template/personalCenter.html",
            // controller: "personalCenterController"
        }).when("/resManage", {
            templateUrl: "./public/template/resManage.html",
            controller: "resController"
        }).when("/autManage", {
            templateUrl: "./public/template/autManage.html",
            controller: "autController"
        }).when("/myDoc", {
            templateUrl: "./public/template/myDoc.html",
            // controller: "UpLoadController"
        }).when("/docList", {
            templateUrl: "./public/template/docList.html",
            controller: "docListController"
        }).when("/history", {
            templateUrl: "./public/template/history.html",
            // controller: "UpLoadController"
        }).when("/personalInfo", {
            templateUrl: "./public/template/personalInfo.html",
            // controller: "UpLoadController"
        }).when("/upload", {
            templateUrl: "./public/template/upload.html",
            // controller: "UpLoadController"
        }).when("/simpleDoc", {
            templateUrl: "./public/template/simpleDoc.html",
            controller: "simpleDocController"
        }).when("/chart", {
            templateUrl: "./public/template/chart.html",
            controller: "chartController"
        }).when("/unAuthority", {
            templateUrl: "./public/template/unAuthority.html",
            // controller: "chartController"

        }).otherwise({
            redirectTo: "/index"
        });

    }]);

    app.controller("indexController", function($scope, $http) {
        location.href = "/login.html";
    })

    app
        .controller(
            'CheckMessageController',
            function($scope) {
                $scope.data = "选课通知：选课将于16周开始，在16周选课之前，请大家先完成评教工作。评教系统将于12月10日（星期二）下午5：30关闭，请大家俺是完成，并确认已扣缴学费或已办理缓交学费，方可选课。";
                $scope.myboolean = true;
                $scope.docData = function() {
                    $scope.myboolean = !$scope.myboolean;
                }
            });

    app.controller('chartController', function($scope, $http) {

        $http({
            url: "./user/userOperationCountStatistics",
            method: "GET",
            params: {

            }
        }).success(function(response) {

            $scope.data = response;
            var myChart1 = echarts.init(document.getElementById('main1'));

            option1 = {
                title: {
                    text: '各员工历史操作统计',
                    subtext: '2016-06',
                    x: 'center'
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data: ['查看', '上传', '下载'],
                    left: 'left'
                },
                toolbox: {
                    feature: {
                        saveAsImage: {}
                    }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: [{
                    type: 'category',
                    boundaryGap: false,
                    data: response.allUserId
                }],
                yAxis: [{
                    type: 'value'
                }],
                series: [{
                    name: '查看',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {
                        normal: {}
                    },
                    data: response.readCount
                        //
                }, {
                    name: '上传',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {
                        normal: {}
                    },
                    data: response.uploadCount
                        //
                }, {
                    name: '下载',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {
                        normal: {}
                    },
                    data: response.downloadCount
                        //
                }]
            };

            myChart1.setOption(option1);

        }).error(function(response) {
            
        })

        $http({
            url: "./user/sectionCountStatistics",
            method: "GET",
            params: {

            }
        }).success(function(response) {

            $scope.data = response;

            var myChart2 = echarts.init(document.getElementById('main2'));

            option2 = {
                title: {
                    text: '各部门上传文档情况',
                    subtext: '2016-06',
                    x: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: response.names
                },
                series: [{
                    name: '占比情况',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '60%'],
                    data: response.nameValues,
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }]
            };
            myChart2.setOption(option2);
        }).error(function(response) {
            
        })
    });

    app.controller('autController', function($scope, $http) {
        $(document).ready(function() {
            var table = $('#table_id').DataTable({
                ajax: {
                    // 指定数据源
                    url: "./user/findSectionReourceTypeAuthorizationList"
                },
                // 每页显示三条数据
                pageLength: 5,
                columns: [{
                    "data": "sectionId"
                }, {
                    "data": "resourceTypeId"
                }, {
                    "data": "userAuthorityId"
                }, {
                    "data": "sectionDescribe"
                }, {
                    "data": "resourceTypeDescribe"
                }, {
                    "data": "userAuthorityDescribe"
                }],
                "columnDefs": [{
                    "visible": false,
                    "targets": 0
                }, {
                    "visible": false,
                    "targets": 1
                }, {
                    "visible": false,
                    "targets": 2
                }]
            });

            $('#table_id tbody').on('click', 'tr', function() {
                if ($(this).hasClass('selected')) {
                    $(this).removeClass('selected');
                } else {
                    table.$('tr.selected').removeClass('selected');
                    $(this).addClass('selected');
                }
            });

            $('#button').click(function() {
                var sb = table.row('.selected').data();

                if (confirm("是否级联删除？")) {
                    $http({
                        url: "./user/deleteSectionReourceTypeAuthorization",
                        method: "GET",
                        params: {
                            sectionId: sb.sectionId,
                            resourceTypeId: sb.resourceTypeId,
                            userAuthorityId: sb.userAuthorityId,
                            isCascade: true
                        }
                    }).success(function(response) {
                        // table.row('.selected').remove().draw(false);
                        location.reload();
                    }).error(function(response) {
                        
                    })
                } else {
                    $http({
                        url: "./user/deleteSectionReourceTypeAuthorization",
                        method: "GET",
                        params: {
                            sectionId: sb.sectionId,
                            resourceTypeId: sb.resourceTypeId,
                            userAuthorityId: sb.userAuthorityId,
                            isCascade: false
                        }
                    }).success(function(response) {
                        location.reload();
                    }).error(function(response) {
                        
                    })

                }

            });

        });

    });
    app.controller('resController', function($scope, $http) {
        $(document).ready(function() {
            var table = $('#table_id').DataTable({
                ajax: {
                    // 指定数据源
                    url: "./doc/findDocListManagered"
                },
                // 每页显示三条数据
                rowId: 'resourceId',
                pageLength: 8,
                columns: [{
                    "data": "resourceId"
                }, {
                    "data": "docName"
                }, {
                    "data": "userName"
                }, {
                    "data": "resourceTypeDescribe"
                }, {
                    "data": "sectionName"
                }, {
                    "data": "time"
                }],

                "columnDefs": [{
                    "visible": false,
                    "targets": 0
                }]

            });

            $('#table_id tbody').on('click', 'tr', function() {
                if ($(this).hasClass('selected')) {
                    $(this).removeClass('selected');
                } else {
                    table.$('tr.selected').removeClass('selected');
                    $(this).addClass('selected');
                }
            });

            $('#button').click(function() {
                table.row
                $http({
                    url: "./doc/deleteResource",
                    method: "GET",
                    params: {
                        resourceId: table.row('.selected').id()
                    }
                }).success(function(response) {
                    table.row('.selected').remove().draw(false);
                }).error(function(response) {
                    
                })

            });
        });
    });

    app.controller('UpLoadController', function($scope, $http) {
        $scope.myboolean2 = true;
        $scope.data = {
            "resManage": true,
            "autManage": true,
            "graph": true,
            "doc": true
        };
        $http({
            url: "/user/menu",
            method: "GET",
            params: {

            }
        }).success(function(response) {

            if (response.data.indexOf("资源管理") >= 0) {
                $scope.data.resManage = false;
            }
            if (response.data.indexOf("权限管理") >= 0) {
                $scope.data.autManage = false;
            }
            if (response.data.indexOf("统计报表") >= 0) {
                $scope.data.graph = false;
            }
            if (response.data.indexOf("查看文档") >= 0) {
                $scope.data.doc = false;
            }
        }).error(function(response) {
            console.log("cuowu");
        })
        $scope.docData2 = function() {
            $scope.myboolean2 = !$scope.myboolean2;
        }
    });

    app.controller('simpleDocController', function($scope, $http) {
        var url = window.location.toString();
        var num = url.substring(url.lastIndexOf('=') + 1, url.length);
        $scope.resNum = num;
        $http({
            url: "./doc/viewDocDetail",
            method: "GET",
            params: {
                resourceId: $scope.resNum
            }
        }).success(function(response) {
            if(response.resourceId != null  && response.resourceId != ''){
            $scope.data = response;
            var startDocument = "Paper";
            $('#documentViewer').FlexPaperViewer({
                config: {
                    SWFFile: response.swfPath,
                    Scale: 0.6,
                    ZoomTransition: 'easeOut',
                    ZoomTime: 0.5,
                    ZoomInterval: 0.2,
                    FitPageOnLoad: true,
                    FitWidthOnLoad: true,
                    FullScreenAsMaxWindow: false,
                    ProgressiveLoading: false,
                    MinZoomSize: 0.2,
                    MaxZoomSize: 5,
                    SearchMatchAll: false,
                    InitViewMode: 'Portrait',
                    RenderingOrder: 'flash',
                    StartAtPage: '',
                    ViewModeToolsVisible: true,
                    ZoomToolsVisible: true,
                    NavToolsVisible: true,
                    CursorToolsVisible: true,
                    SearchToolsVisible: true,
                    WMode: 'window',
                    localeChain: 'en_US'
                }
            });
           }else{
                location.href = "/index.html#/unAuthority";
           }
        }).error(function(response) {
            
        })

    /*    $scope.download = function() {
            $http({
                url: "./doc/download",
                method: "POST",
                params: {
                    resourceId: $scope.resNum
                },
            	headers : { 'Content-Type': 'application/x-www-form-urlencoded' } 
            }).success(function(response) {

            }).error(function(response) {
                alert('shabi');
            })
        }*/
    });

}(angular, window);
