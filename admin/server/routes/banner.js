// /api/banner
const express = require('express');
const db = require('../core/db');

const router = express.Router();

router.get('/', (req, res) => {
  const con = [];
  con['1'] = 1;
  if (req.query.search) {
    con.like = `title like '%${req.query.search}%'`;
  }
  con.orderBy = 'addtime desc';
  db.Select('qm_banner', con, (err, response) => {
    res.send(response || []);
  });
});

router.get('/:id', (req, res) => {
  const con = [];
  con.id = parseInt(req.params.id, 10);
  db.Select('qm_banner', con, (err, response) => {
    res.send(response[0]);
  });
});

router.post('/', (req, res) => {
  const insertData = [];
  insertData.title = req.body.title;
  insertData.addtime = Date.parse(new Date()) / 1000;
  insertData.updatetime = insertData.addtime;
  insertData.img = req.body.img;
  insertData.sort = req.body.sort;
  db.Insert('qm_banner', insertData, (err, response) => {
    res.send(response);
  });
});

router.put('/:id', (req, res) => {
  const updateData = [];
  const con = [];
  con.id = parseInt(req.params.id, 10);
  updateData.title = req.body.title;
  updateData.updatetime = Date.parse(new Date()) / 1000;
  updateData.img = req.body.img;
  updateData.sort = req.body.sort;
  db.Update('qm_banner', updateData, con, (err, response) => {
    res.send(response);
  });
});

router.delete('/:id', (req, res) => {
  const con = [];
  con.id = parseInt(req.params.id, 10);
  db.Delete('qm_banner', con, (err, response) => {
    res.send(response);
  });
});

module.exports = router;
