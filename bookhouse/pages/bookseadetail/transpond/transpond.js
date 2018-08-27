// pages/bookseadetail/transpond/transpond.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    image: "",
    title:"",
    content: ""
  },
  inputcontent(e) {
    var that = this
    that.setData({
      content: e.detail.value
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this;
    that.setData({
      image: options.image,
      title:options.title
    })

    //console.log(options.image)
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },
  userNameInput: function(e) {
    console.log(e.detail.value)
    this.setData({
      content: e.detail.value
    })
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function(res) {
    var that = this
   // console.log(that.data.content)
    if (res.from === 'button') {
      console.log("来自页面内转发按钮");
     // console.log(res.target);
    }
    else {
      console.log("来自右上角转发菜单")
    }
    return {
      title: that.data.content,
      path: '../../bookseadetail/bookseadetail?image='+that.data.image+'&title='+that.data.title,
     
      success: (res) => {
        console.log("转发成功", res);
      },
      fail: (res) => {
        console.log("转发失败", res);
      }
    }


  }


})