export default [
  {
    path: "/login",
    component: "../layouts/UserLayout",
    routes: [
      {
        name: "login",
        path: "/login",
        component: "./login"
      }
    ]
  },
  {
    path: "/",
    component: "../layouts/SecurityLayout",
    routes: [
      {
        path: "/",
        component: "../layouts/BasicLayout",
        authority: ["admin", "user"],
        routes: [
          {
            path: "/",
            redirect: "/home"
          },
          {
            path: "/home",
            name: "home",
            icon: "home",
            component: "./Home"
          },
          // // 表格功能
          // {
          //   path: "/table",
          //   name: "table",
          //   icon: "smile",
          //   component: "../layouts/ContentLayout",
          //   routes: [
          //     {
          //       path: "/table",
          //       hideInMenu: true,
          //       component: "./table/index"
          //     },
          //     {
          //       path: "/table/add",
          //       name: "add",
          //       hideInMenu: true,
          //       component: "./table/add"
          //     },
          //     {
          //       path: "/table/update/:id",
          //       name: "update",
          //       hideInMenu: true,
          //       component: "./table/update"
          //     },
          //     {
          //       component: "./404"
          //     }
          //   ]
          // },
          // 软文功能
          {
            path: "/article",
            name: "article",
            icon: "file-markdown",
            component: "../layouts/ContentLayout",
            routes: [
              {
                path: "/article",
                hideInMenu: true,
                component: "./article/index"
              },
              {
                path: "/article/add",
                name: "add",
                hideInMenu: true,
                component: "./article/add"
              },
              {
                path: "/article/update/:id",
                name: "update",
                hideInMenu: true,
                component: "./article/update"
              },
              {
                component: "./404"
              }
            ]
          },
          // 管理员信息
          {
            path: "/account",
            hideInMenu: true,
            name: "account",
            component: "../layouts/ContentLayout",
            routes: [
              {
                path: "/account",
                redirect: "/account/info"
              },
              {
                path: "/account/info",
                name: "admininfo",
                hideInMenu: true,
                component: "./account/info"
              },
              {
                path: "/account/log",
                hideInMenu: true,
                name: "adminlog",
                component: "./account/log"
              },
              {
                path: "/account/add",
                name: "add",
                hideInMenu: true,
                component: "./account/add"
              },
              {
                path: "/account/update/:id",
                name: "update",
                hideInMenu: true,
                component: "./account/update"
              },
              {
                component: "./404"
              }
            ]
          },
          {
            component: "./404"
          }
        ]
      },
      {
        component: "./404"
      }
    ]
  },
  {
    component: "./404"
  }
];
