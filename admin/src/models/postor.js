// 引入所有的请求接口
import { getList } from '@/services/postor';

export default {
  // 空间名称
  namespace: 'postor',

  // 状态值
  state: {
    list: [],
  },

  // action和数据异步处理
  effects: {
    // 查
    *select({ params }, { call, put }) {
      const response = yield call(getList, params);
      yield put({
        type: 'queryList',
        payload: response,
      });
      return response;
    },
  },

  // 更新全局state
  reducers: {
    queryList(state, action) {
      return {
        ...state,
        list: action.payload,
      };
    },
  },
};
