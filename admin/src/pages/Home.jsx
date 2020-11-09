import React from 'react';
import { Card, Alert } from 'antd';

export default () => (
  <Card>
    <Alert
      message="qm_admin.16to.com首页"
      type="success"
      showIcon
      banner
      style={{
        margin: -12,
        marginBottom: 24,
      }}
    />
  </Card>
);
