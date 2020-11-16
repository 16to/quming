// /api/postor
const express = require('express');
const db = require('../core/db');
const utils = require('../core/utils');

const router = express.Router();

router.get('/', (req, res) => {
  const con = [];
  con['1'] = 1;
  if (req.query.search) {
    con.like = `client like '%${req.query.search}%'`;
  }
  con.orderBy = 'postortime desc';
  db.Select('qm_postor', con, (err, response) => {
    res.send(response || []);
  });
});

// 添加访问记录
router.post('/', (req, res) => {
  const insertData = [];
  insertData.client = req.body.client;
  insertData.postortime = Date.parse(new Date());
  insertData.postorbirthday = req.body.birthday;
  insertData.postorfname = req.body.fname;
  insertData.postorsex = req.body.sex;
  db.Insert('qm_postor', insertData, (err, response) => {
    res.send(response);
  });
});

module.exports = router;
