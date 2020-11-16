import React, { PureComponent } from 'react';
import { Input, Form, Select, InputNumber } from 'antd';
import UploadImg from '@/components/UploadImg';

import { connect } from 'dva';

@connect(({ sysconfig, settings }) => ({
  sysconfig: sysconfig.sysconfig,
  imgBase: settings.imgBase,
  author:settings.author,
}))
@Form.create()
class BasicForm extends PureComponent {
  state = {
  }

  // DOM挂载之前
  componentWillMount() {
  }

  // DOM挂载之前
  componentDidMount() {
  }

  changeUpload = fileList => {
    const { form } = this.props;
    form.setFieldsValue({
      img: (fileList[0] && fileList[0].response && fileList[0].response.imagename) || '',
    });
  }

  // jsx渲染
  render() {
    // 页面内容
    const { updateData, form: { getFieldDecorator }, imgBase } = this.props;
    const formItemLayout = {
      labelCol: {
        xs: { span: 24 },
        sm: { span: 4 },
      },
      wrapperCol: {
        xs: { span: 24 },
        sm: { span: 12 },
        md: { span: 16 },
      },
    };
    return (
      <div>
      <Form onSubmit={this.handleSubmit} style={{ marginTop: 8 }}>
        <Form.Item {...formItemLayout} label="标题">
          {getFieldDecorator('title', {
            initialValue: updateData ? updateData && updateData.title : undefined,
            rules: [
              {
                required: true,
                message: '必填',
              },
            ],
          })(<Input placeholder="请输入标题" />)}
        </Form.Item>
        <Form.Item {...formItemLayout} label="排序">
          {getFieldDecorator('sort', {
            initialValue: updateData ? updateData && updateData.sort : 0,
            rules: [
              {
                required: true,
                message: '必填',
              },
            ],
          })(<InputNumber placeholder="请输入排序，数字越大越靠前" />)}
        </Form.Item>
        <Form.Item {...formItemLayout} label="单个图片750*400">
          {getFieldDecorator('img', {
            initialValue: updateData ? updateData && updateData.img : '',
            rules: [
              {
                required: true,
                message: '必填',
              },
            ],
          })(<Input hidden />)}
          <UploadImg
            imgBase={imgBase}
            initialValue={updateData ? updateData && updateData.img : ''}
            onChange={this.changeUpload}
          />
        </Form.Item>
      </Form>
      </div>
    );
  }
}
export default BasicForm;
