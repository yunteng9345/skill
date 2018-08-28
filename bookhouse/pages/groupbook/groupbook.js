// pages/groupbook/groupbook.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    "profess": [
      {
        "pid": "1",
        "pname": "群组一"
      },
      {
        "pid": "2",
        "pname": "书吧2",
       
      },
      {
        "pid": "3",
        "pname": "群组三",
       
      },
      
      
    ],
    list:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this
    that.setData({
      list: that.data.profess
    })
  
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

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function (res) {

    wx.showShareMenu({
      withShareTicket:true
    })
    
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
      path: '../groupbookdetail/groupbookdetail',

      success: (res) => {
        // 转发成功  
        var shareTickets = res.shareTickets;
        var shareTicket = shareTickets;  
        console.log("转发成功", res);
        wx.getShareInfo({
          shareTicket: shareTicket,
          success: function (res) {
           // console.log('success');
            console.log(res);
           
          
           
            wx.showToast({
              title: '转发成功',
              duration: 5000
            })
          }
        })

      },
      fail: (res) => {
        console.log("转发失败", res);
      }
    }
    }
  
})