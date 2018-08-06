// pages/dati/dati.js
var i=0
Page({

  /**
   * 页面的初始数据
   */
  data: {

    timu: "",
    ti:"",
    result:"",
    flag:''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.request({
      url: 'http://localhost:8080/timu/dati?guanka=' + options.id,
      header: {//请求头
        "Content-Type": "applciation/json"
      },
      method: "GET",//get为默认方法/POST
      success: function (res) {
         
        wx.setStorage({
          key: "timu",
          data: res.data.timu
        })
        
        wx.getStorage({
          key: 'timu',
          success: function (res) {
            that.setData({
              timu: res.data[i]
            })
          }
        })
      },
      fail: function (err) {

      }
    })
    console.log("onLoad," + options.id);
  },

/*
A,B,C,D选择后判断是否正确
*/
  butA: function (e) {
    var that = this;
    var ta = e.currentTarget.dataset.ta
    var ans = e.currentTarget.dataset.ans
    
    if(ta==ans){
     
      that.setData({
        result: "正确",
        flag: true
      })
    }else{
      that.setData({
        result: "错误，正确答案是："+ans
      })
      
    }
    

  },
  butB: function (e) {
    var that=this;
    var tb = e.currentTarget.dataset.tb
    var ans = e.currentTarget.dataset.ans
    if (tb == ans) {
     
      that.setData({
        result: "正确",
        flag:true
      })
    } else {
      that.setData({
        result: "错误，正确答案是：" + ans
      })
     
    }

  },
  butC: function (e) {
    var that = this;
    var tc = e.currentTarget.dataset.tc
    var ans = e.currentTarget.dataset.ans
    if (tc == ans) {
     
      that.setData({
        result: "正确",
        flag: true
      })
    } else {
      that.setData({
        result: "错误，正确答案是：" + ans
      })
      
    }

  },
  butD: function (e) {
    var that = this;
    var td = e.currentTarget.dataset.td
    var ans = e.currentTarget.dataset.ans
    if (td == ans) {
      
      that.setData({
        result: "正确",
        flag: true
      })
    } else {
      that.setData({
        result: "错误，正确答案是：" + ans
      })
     
    }

  },

  /*
  下一题
  */
  refresh(e)
  {
    var that = this;
    if (e.currentTarget.dataset.td==null){
      wx.showToast({
        title: '本关卡通过！',
        icon: 'succes',
        duration: 1000,
        mask: true
      })
    }
    else{
      wx.getStorage({
        key: 'timu',
        success: function (res) {
          i++;
          that.setData({
            timu: res.data[i]
          })
        }
      })
    }
    
    
  },
  /*
加入错题本
  */
  joinbook(e){
    var tcontent = e.currentTarget.dataset.tcontent
    var ta = e.currentTarget.dataset.ta
    var tb = e.currentTarget.dataset.tb
    var tc = e.currentTarget.dataset.tc
    var td = e.currentTarget.dataset.td
    var ans = e.currentTarget.dataset.ans

  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function (options) {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
    i=0;
    console.log("onUnload")
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})