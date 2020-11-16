import React, { PureComponent } from 'react';
import { Modal, Button, Table, Divider, Card, Input } from 'antd';
import { connect } from 'dva';
import moment from 'moment';
import router from 'umi/router';

const { Search } = Input;

// 链接dva的状态数据
@connect(({ postor, sysconfig, loading }) => ({
  list: postor.list,
  sysconfig: sysconfig.sysconfig,
  loading: loading.effects['postor/select'],
}))
class List extends PureComponent {
  state = {};

  // 定义表格头
  columns = [
    {
      title: '终端信息',
      dataIndex: 'client',
      key: 'client',
    },
    {
      title: '请求时间',
      dataIndex: 'postortime',
      key: 'postortime',
      sorter: (a, b) => a.postortime - b.postortime,
      render: val => <span>{moment(val).format('YYYY-MM-DD HH:mm:ss')}</span>,
    },
    {
      title: '性别',
      dataIndex: 'postorsex',
      key: 'postorsex',
      sorter: (a, b) => a.postorsex - b.postorsex,
    },
    {
      title: '姓氏',
      dataIndex: 'postorfname',
      key: 'postorfname',
      sorter: (a, b) => a.postorfname - b.postorfname,
    },
    {
      title: '出生日期',
      dataIndex: 'postorbirthday',
      key: 'postorbirthday',
      sorter: (a, b) => a.postorbirthday - b.postorbirthday,
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
      type: 'postor/select',
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

  // 搜索
  search = value => {
    this.params.search = value;
    if (value === '') {
      this.params.search = undefined;
    }
    this.getTableData();
  };

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