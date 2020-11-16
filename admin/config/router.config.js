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
          // 横幅管理
          {
            path: "/banner",
            name: "banner",
            icon: "ordered-list",
            component: "../layouts/ContentLayout",
            routes: [
              {
                path: "/banner",
                hideInMenu: true,
                component: "./banner/index"
              },
              {
                path: "/banner/add",
                name: "add",
                hideInMenu: true,
                component: "./banner/add"
              },
              {
                path: "/banner/update/:id",
                name: "update",
                hideInMenu: true,
                component: "./banner/update"
              },
              {
                component: "./404"
              }
            ]
          },
          // 访问列表
          {
            path: "/visitor",
            name: "visitor",
            icon: "user",
            component: "../layouts/ContentLayout",
            routes: [
              {
                path: "/visitor",
                hideInMenu: true,
                component: "./visitor/index"
              },
              {
                component: "./404"
              }
            ]
          },
          // 请求列表
          {
            path: "/postor",
            name: "postor",
            icon: "link",
            component: "../layouts/ContentLayout",
            routes: [
              {
                path: "/postor",
                hideInMenu: true,
                component: "./postor/index"
              },
              {
                component: "./404"
              }
            ]
          },
          // 软文管理
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
