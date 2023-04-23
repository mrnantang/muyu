const db = require("../db/db");
// 查看今日功德
todayMorality =(req,res)=>{
    const sqlStr = "select * from list where create_time = CURDATE() order by value desc limit 10";
    db.query(sqlStr, (err, results) => {
      if (err) {
        return console.log("err", err.message);
      }
      if (results.length >= 1) {
        res.send({
          status: 200,
          msg: "查询成功",
          data: results,
        });
      } else {
        res.send({
          status: 201,
          msg: "暂无功德",
        });
      }
    });
}
module.exports = todayMorality