// pages/bookseadetail/transpond/transpond.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
  image:"",
  content:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
    that.setData({
      image: options.image
    })
    
    //console.log(options.image)
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
  userNameInput: function (e) {
    console.log(e.detail.value)
    this.setData({
      content: e.detail.value
    })
  }
,

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function (res) {
    if (res.from === 'button') {
      var c=content
      console.log(res.target)
    }
    return {
      title: c,
      path: './groupbook/groupbook'
    }
  }
})