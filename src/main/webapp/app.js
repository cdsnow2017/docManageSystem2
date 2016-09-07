var express = require("express");
var app = express();

var bodyParser = require('body-parser');
app.use(bodyParser.json("{type:'application/*+json'}"));

app.use("/", express.static(__dirname + "/"));


app.post("/loginCheck", function(req, res) {
    console.log(req.body);
    // 测试数据 
    var example = {
        leader: {
            name: "leader",
            password: "leader"
        },
        res: {
            name: "res",
            password: "res"
        },
        sys: {
            name: "sys",
            password: "sys"
        },
        sr: {
            name: "sr",
            password: "sr"
        },

    };

    // 提取数据
    if (req.body) {
        var user = {
                name: req.body.userName,
                password: req.body.password
            }
            // 处理
        switch (user.name) {
            case "sr":
                compareUser(user, example.sr);
                break;
            default:
                compareUser(user, example.sr);
                break;
        }

    }
    // 验证
    function compareUser(loginUser, targetUser) {
        if (loginUser.name === targetUser.name) {
            if (loginUser.password === targetUser.password) {
                res.end("1"); //登陆成功
            } else {
                res.end("2"); //密码不对
            }
        } else {
            res.end("3"); //无此用户
        }
    }



})



app.listen(3000);
