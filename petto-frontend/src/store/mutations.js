import { 
  FETCH_USER_INFO, 
  FETCH_SESSION,
  
  FETCH_FACILITY_LIST,
  FETCH_FACILITY_INFO,

  FETCH_ANIMAL_LIST,
  FETCH_ANIMAL_INFO,

  FETCH_LIKED_ANIMAL_LIST,

  FETCH_ORDER_ANIMAL_LIST,

  FETCH_LIKED_ANIMAL_CNT,

  FETCH_REPORT_LIST

  
} from "./mutation-types";

export default {
  [FETCH_USER_INFO] (state, payload) {
    state.userInfo = payload;
  },
  //세션
  [FETCH_SESSION] (state) {
    state.session = this.$cookies.get();
  },

  [FETCH_FACILITY_LIST] (state, payload) {
    state.facilityList = payload
  },

  [FETCH_FACILITY_INFO] (state, payload) {
    state.facilityInfo = payload
  },
  
  [FETCH_ANIMAL_LIST] (state, animals) {
    //alert(JSON.stringify(animals[1]))
    state.animals = animals;
  },
  
  [FETCH_ANIMAL_INFO] (state, animals) {
    state.animalsInfo = animals;
  },

  [FETCH_LIKED_ANIMAL_LIST] (state, payload) {
    state.likedAnimalList = payload;
  },

  [FETCH_ORDER_ANIMAL_LIST](state, olderList) {
    state.olderList = olderList;
  },

  [FETCH_LIKED_ANIMAL_CNT] (state, payload) {
    state.likedAnimalCnt = payload;
  },

  [FETCH_REPORT_LIST] (state, payload) {
    state.reportList = payload
  }

};
