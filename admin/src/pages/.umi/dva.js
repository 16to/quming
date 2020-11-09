import dva from 'dva';
import { Component } from 'react';
import createLoading from 'dva-loading';
import history from '@tmp/history';

let app = null;

export function _onCreate() {
  const plugins = require('umi/_runtimePlugin');
  const runtimeDva = plugins.mergeConfig('dva');
  app = dva({
    history,
    
    ...(runtimeDva.config || {}),
    ...(window.g_useSSR ? { initialState: window.g_initialData } : {}),
  });
  
  app.use(createLoading());
  (runtimeDva.plugins || []).forEach(plugin => {
    app.use(plugin);
  });
  
  app.model({ namespace: 'account', ...(require('/Users/zj/Desktop/pro/quming/admin/src/models/account.js').default) });
app.model({ namespace: 'article', ...(require('/Users/zj/Desktop/pro/quming/admin/src/models/article.js').default) });
app.model({ namespace: 'global', ...(require('/Users/zj/Desktop/pro/quming/admin/src/models/global.js').default) });
app.model({ namespace: 'login', ...(require('/Users/zj/Desktop/pro/quming/admin/src/models/login.js').default) });
app.model({ namespace: 'setting', ...(require('/Users/zj/Desktop/pro/quming/admin/src/models/setting.js').default) });
app.model({ namespace: 'sysconfig', ...(require('/Users/zj/Desktop/pro/quming/admin/src/models/sysconfig.js').default) });
app.model({ namespace: 'table', ...(require('/Users/zj/Desktop/pro/quming/admin/src/models/table.js').default) });
app.model({ namespace: 'user', ...(require('/Users/zj/Desktop/pro/quming/admin/src/models/user.js').default) });
  return app;
}

export function getApp() {
  return app;
}

export class _DvaContainer extends Component {
  render() {
    const app = getApp();
    app.router(() => this.props.children);
    return app.start()();
  }
}
