const db = require("../db/db");
// 提交功德
commit = (req, res) => {
  const { userName, count } = req.body;
  // 限制用户名长度
  if (userName.length > 10) {
    res.send({
      status: 202,
      msg: "用户名长度不能超过10个字符",
    });
    return;
  }
  // 查询数据库有没有同名的用户
  const selStr = "select userName from list where userName = ?";
  db.query(selStr, userName, (err, results) => {
    if (err) {
      return console.log("err", err.message);
    }
    if (results.length >= 1) {
      res.send({
        status: 201,
        msg: "该用户名已存在",
      });
    } else {
      // 新增数据库数据
      const sqlStr =
        "insert into list set userName = ? , value = ? ,create_time = now()";
      db.query(sqlStr, [userName, count], function (err, results) {
        if (err) {
          return console.log("err", err.message);
        }
        if (results.affectedRows === 1) {
          res.send({
            status: 200,
            msg: "恭喜你，功德上传成功",
          });
        }
      });
    }
  });
};

module.exports = commit;
