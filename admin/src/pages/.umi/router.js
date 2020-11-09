import React from 'react';
import { Router as DefaultRouter, Route, Switch } from 'react-router-dom';
import dynamic from 'umi/dynamic';
import renderRoutes from 'umi/lib/renderRoutes';
import history from '@tmp/history';
import RendererWrapper0 from '/Users/zj/Desktop/pro/quming/admin/src/pages/.umi/LocaleWrapper.jsx';

const Router = require('dva/router').routerRedux.ConnectedRouter;

const routes = [
  {
    path: '/login',
    component: require('../../layouts/UserLayout').default,
    routes: [
      {
        name: 'login',
        path: '/login',
        component: require('../login').default,
        exact: true,
      },
      {
        component: () =>
          React.createElement(
            require('/Users/zj/Desktop/pro/quming/admin/node_modules/umi-build-dev/lib/plugins/404/NotFound.js')
              .default,
            { pagesPath: 'src/pages', hasRoutesInConfig: true },
          ),
      },
    ],
  },
  {
    path: '/',
    component: require('../../layouts/SecurityLayout').default,
    routes: [
      {
        path: '/',
        component: require('../../layouts/BasicLayout').default,
        authority: ['admin', 'user'],
        routes: [
          {
            path: '/',
            redirect: '/home',
            exact: true,
          },
          {
            path: '/home',
            name: 'home',
            icon: 'home',
            component: require('../Home').default,
            exact: true,
          },
          {
            path: '/article',
            name: 'article',
            icon: 'file-markdown',
            component: require('../../layouts/ContentLayout').default,
            routes: [
              {
                path: '/article',
                hideInMenu: true,
                component: require('../article/index').default,
                exact: true,
              },
              {
                path: '/article/add',
                name: 'add',
                hideInMenu: true,
                component: require('../article/add').default,
                exact: true,
              },
              {
                path: '/article/update/:id',
                name: 'update',
                hideInMenu: true,
                component: require('../article/update').default,
                exact: true,
              },
              {
                component: require('../404').default,
                exact: true,
              },
              {
                component: () =>
                  React.createElement(
                    require('/Users/zj/Desktop/pro/quming/admin/node_modules/umi-build-dev/lib/plugins/404/NotFound.js')
                      .default,
                    { pagesPath: 'src/pages', hasRoutesInConfig: true },
                  ),
              },
            ],
          },
          {
            path: '/account',
            hideInMenu: true,
            name: 'account',
            component: require('../../layouts/ContentLayout').default,
            routes: [
              {
                path: '/account',
                redirect: '/account/info',
                exact: true,
              },
              {
                path: '/account/info',
                name: 'admininfo',
                hideInMenu: true,
                component: require('../account/info').default,
                exact: true,
              },
              {
                path: '/account/log',
                hideInMenu: true,
                name: 'adminlog',
                component: require('../account/log').default,
                exact: true,
              },
              {
                path: '/account/add',
                name: 'add',
                hideInMenu: true,
                component: require('../account/add').default,
                exact: true,
              },
              {
                path: '/account/update/:id',
                name: 'update',
                hideInMenu: true,
                component: require('../account/update').default,
                exact: true,
              },
              {
                component: require('../404').default,
                exact: true,
              },
              {
                component: () =>
                  React.createElement(
                    require('/Users/zj/Desktop/pro/quming/admin/node_modules/umi-build-dev/lib/plugins/404/NotFound.js')
                      .default,
                    { pagesPath: 'src/pages', hasRoutesInConfig: true },
                  ),
              },
            ],
          },
          {
            component: require('../404').default,
            exact: true,
          },
          {
            component: () =>
              React.createElement(
                require('/Users/zj/Desktop/pro/quming/admin/node_modules/umi-build-dev/lib/plugins/404/NotFound.js')
                  .default,
                { pagesPath: 'src/pages', hasRoutesInConfig: true },
              ),
          },
        ],
      },
      {
        component: require('../404').default,
        exact: true,
      },
      {
        component: () =>
          React.createElement(
            require('/Users/zj/Desktop/pro/quming/admin/node_modules/umi-build-dev/lib/plugins/404/NotFound.js')
              .default,
            { pagesPath: 'src/pages', hasRoutesInConfig: true },
          ),
      },
    ],
  },
  {
    component: require('../404').default,
    exact: true,
  },
  {
    component: () =>
      React.createElement(
        require('/Users/zj/Desktop/pro/quming/admin/node_modules/umi-build-dev/lib/plugins/404/NotFound.js')
          .default,
        { pagesPath: 'src/pages', hasRoutesInConfig: true },
      ),
  },
];
window.g_routes = routes;
const plugins = require('umi/_runtimePlugin');
plugins.applyForEach('patchRoutes', { initialValue: routes });

export { routes };

export default class RouterWrapper extends React.Component {
  unListen = () => {};

  constructor(props) {
    super(props);

    // route change handler
    function routeChangeHandler(location, action) {
      plugins.applyForEach('onRouteChange', {
        initialValue: {
          routes,
          location,
          action,
        },
      });
    }
    this.unListen = history.listen(routeChangeHandler);
    routeChangeHandler(history.location);
  }

  componentWillUnmount() {
    this.unListen();
  }

  render() {
    const props = this.props || {};
    return (
      <RendererWrapper0>
        <Router history={history}>{renderRoutes(routes, props)}</Router>
      </RendererWrapper0>
    );
  }
}
