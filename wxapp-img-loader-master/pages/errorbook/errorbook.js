// pages/errorbook/errorbook.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
  timu:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function () {
    // var that = this;
    // wx.request({
    //   url: 'http://localhost:8080/timu/errorTimu',
    //   header: { //请求头
    //     "Content-Type": "applciation/json"
    //   },
    //   method: "GET", //get为默认方法/POST
    //   success: function (res) {
    //     that.setData({
    //       timu: res.data
    //     })
       
    //   },
    //   fail: function (err) {

    //   }
    // })
  console.log("cuoti onload")
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    console.log("cuoti onshow")
    var that = this;
    wx.request({
      url: 'http://localhost:8080/timu/errorTimu',
      header: { //请求头
        "Content-Type": "applciation/json"
      },
      method: "GET", //get为默认方法/POST
      success: function (res) {
        that.setData({
          timu: res.data
        })

      },
      fail: function (err) {

      }
    })
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