import React, { PureComponent } from 'react';
import { Modal, Button, Table, Divider, Card, Input } from 'antd';
import { connect } from 'dva';
import moment from 'moment';
import router from 'umi/router';

const { Search } = Input;

// 链接dva的状态数据
@connect(({ banner, sysconfig, loading,settings }) => ({
  list: banner.list,
  sysconfig: sysconfig.sysconfig,
  imgBase: settings.imgBase,
  loading: loading.effects['banner/select'],
}))
class List extends PureComponent {
  state = {};

  // 定义表格头
  columns = [
    {
      title: '标题',
      dataIndex: 'title',
      key: 'title',
      render: (val, record) => (
        <a onClick={() => this.updateBtn(record.id)}>{val}</a>
      ),
    },
    {
      title: '排序',
      dataIndex: 'sort',
      key: 'sort',
    },
    {
      title: '图片',
      dataIndex: 'img',
      key: 'img',
      render: val => (
        <a onClick={() => this.picInfo(val)}>
          {val}
        </a>
      ),
    },
    {
      title: '添加时间',
      dataIndex: 'addtime',
      key: 'addtime',
      sorter: (a, b) => a.addtime - b.addtime,
      render: val => <span>{moment(val * 1000).format('YYYY-MM-DD HH:mm:ss')}</span>,
    },
    {
      title: '操作',
      key: 'action',
      width: '120px',
      render: (_text, record) => (
        <span>
          <Button
            onClick={() => this.updateBtn(record.id)}
            shape="circle"
            icon="edit"
            title="编辑"
            size="small"
          />
          <Divider type="vertical" />
          <Button
            onClick={() => this.deleteBtn(record)}
            shape="circle"
            icon="delete"
            title="删除"
            size="small"
          />
        </span>
      ),
    },
  ];

  params = {
    page: 1,
    pageSize: 10,
  };

  // DOM挂载之后
  componentDidMount() {
    this.getTableData();
  }

  // 查询表格数据
  getTableData = () => {
    const { dispatch } = this.props;
    dispatch({
      type: 'banner/select',
      params: this.params,
    });
  };

  // 页码操作
  handlePainationChange = current => {
    this.params.page = current;
    this.getTableData();
  };

  // 页数变化
  handlePainationSizeChange = (current, size) => {
    this.params.page = current;
    this.params.pageSize = size;
    this.getTableData();
  };

  // 删除数据按钮
  deleteBtn = record => {
    Modal.confirm({
      title: '删除数据',
      content: (
        <div>
          此操作将会删除<b>{record.title}</b>的相关数据
          <br />
          注意：删除之后将无法恢复。
        </div>
      ),
      okText: '确认',
      cancelText: '取消',
      width: 400,
      onOk: () => this.sendDeleteId(record.id),
    });
  };

  // 发送删除id的请求
  sendDeleteId = id => {
    const { dispatch } = this.props;
    dispatch({
      type: 'banner/delete',
      id,
    });
  };

  // 搜索
  search = value => {
    this.params.search = value;
    if (value === '') {
      this.params.search = undefined;
    }
    this.getTableData();
  };

  // 添加按钮
  addBtn = () => {
    router.push('/banner/add');
  };

  // 修改按钮
  updateBtn = id => {
    router.push(`/banner/update/${id}`);
  };

  // 展示图片
  picInfo = src => {
    const { imgBase } = this.props;
    Modal.info({
      content: (
        <img src={imgBase + src} style={{ width: '100%' }} alt="img" />
      ),
      icon: false,
      okText: '知道了',
      maskClosable: true,
    })
  }

  render() {
    const { list, loading } = this.props;
    const pagination = {
      current: this.params.page,
      showSizeChanger: true,
      showQuickJumper: true,
      pageSizeOptions: ['10', '20', '50', '100'],
      total: (list && list.totalCount) || 0,
      showTotal: total => `总条数：${total}`,
      onChange: this.handlePainationChange,
      onShowSizeChange: this.handlePainationSizeChange,
    };
    return (
      <Card>
        <p>
          <Button
            type="primary"
            icon="plus"
            className="pull-right"
            onClick={this.addBtn}
          >
            新建
          </Button>
          <Search
            placeholder="请输入关键词"
            onSearch={value => this.search(value)}
            style={{ width: 200 }}
          />
        </p>
        <Table
          columns={this.columns}
          dataSource={list}
          rowKey="id"
          loading={loading}
          pagination={pagination}
        />
      </Card>
    );
  }
}
export default List;
