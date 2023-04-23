const db = require("../db/db");
// 查看总功德
totalMorality =(req,res)=>{
    const sqlStr = "select * from list order by value desc limit 10";
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
module.exports = totalMorality