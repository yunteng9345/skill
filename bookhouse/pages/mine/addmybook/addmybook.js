//import "··/··/libs/qqmap-wx-jssdk.js"
var QQMapWX = require('/libs/qqmap-wx-jssdk.js')

// 实例化API核心类
var demo = new QQMapWX({
  key: 'DJ4BZ-RBZ6V-V3TPR-USW4D-NQFUS-XTFG4'
});

// pages/mine/addmybook/addmybook.js
//地图功能单独拿出来 -xzz1023
var village_LBS = function(that) {
  wx.getLocation({
    type: 'gcj02', //返回可以用于wx.openLocation的经纬度
    success: function(res) {
      // 调用接口, 坐标转具体位置 -xxz0717
      demo.reverseGeocoder({
        location: {
          latitude: Number(res.latitude),
          longitude: Number(res.longitude)
        },
        success: function(res) {
          console.log(res);
          // that.setData({
          //   start_address: res.result.address,   //起点地址
          //   city: res.result.address_component.city,  //起点城市
          //   district: res.result.address_component.district   //区
          // })
        }
      })
    }


  })
}

Page({

  /**
   * 页面的初始数据
   */
  data: {
    title: "",
    image: "",
    author: "",
    isbn: "",
    address:"",
    name:"",
    bookbar:"无书吧"
   // ownBookBar:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
     var that = this;
    // village_LBS(that);

    wx.getStorage({
      key: 'isbn',
      success: function(res) {
        that.setData({
          title: options.title,
          image: options.image,
          author: options.author,
          isbn: res.data,
          bookbar:options.bookbar
        })
      },
    })


    ///console.log(isbn)
  },
  formSubmit: function(e) {
    var that = this;
    //console.log('form发生了submit事件，携带数据为：', e.detail.value.image)
    wx.getStorage({
      key: 'openid',
      success: function (res) {
        //var openid = res.data
        //console.log(this.image)
        wx.request({
          method: 'GET',
          url: 'http://localhost:8080/kq/json/addBook',
          header: { //请求头
            "Content-Type": "applciation/json"
          },
          data: {
            "openid": res.data,
            "isbn": that.data.isbn,
            "title": e.detail.value.title,
            "author": e.detail.value.author,
            "image": that.data.image,
            "send_word": e.detail.value.sendword,
            "ownBookBar":that.data.bookbar
          
          },

          success: function (res) {
            console.log("用户信息到服务器success")
            wx.navigateTo({
              url: '../mybook/mybook',
            })
          }
        })

      },
    })
    // var that = this;

    // console.log('form发生了submit事件，携带数据为：', e.detail.value.title)
    // wx.getStorage({
    //   key: 'openid',
    //   success: function(res) {
    //     var that =this;       
    //     wx.request({
          
    //       method: 'GET',
    //       url: 'http://localhost:8080/kq/json/addBook',
    //       header: { //请求头
    //         "Content-Type": "applciation/json"
    //       },
    //       data: {
    //         "openid": res.data,
    //        "isbn": that.data.isbn,
    //         "title": that.data.title,
    //         "author": that.data.author,
    //         "image": that.data.image,
    //         "send_word": e.detail.value.sendword,
    //         //"ownBookBar":that.data.ownBookBar
    //       },

    //       success: function(res) {
    //         console.log("书籍信息到服务器success")
    //         wx.navigateTo({
    //           url: '../mybook/mybook',
    //         })
    //       },
    //       fail:function(e){
    //         console.log(e)
    //       }
    //     })

    //   },
    // })

  },
  selectAdd() {

    wx.getLocation({
      type: "gcj02",
      success: function(res) {
        wx.openLocation({
          latitude: res.latitude,
          longitude: res.longitude,
          success: function(res) {
            wx.chooseLocation({
              success: function(res) {
                wx.navigateTo({
                 
                })
                //console.log(res.address);
                //console.log(res.name);
              },
            })

          }
        })
        //console.log(res)
      },
    })
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {


    var that = this;
    wx.getSetting({
      success: (res) => {
        console.log(res);
        console.log(res.authSetting['scope.userLocation']);
        if (res.authSetting['scope.userLocation'] != undefined && res.authSetting['scope.userLocation'] != true) { //非初始化进入该页面,且未授权
          wx.showModal({
            title: '是否授权当前位置',
            content: '需要获取您的地理位置，请确认授权，否则地图功能将无法使用',
            success: function(res) {
              if (res.cancel) {
                console.info("1授权失败返回数据");

              } else if (res.confirm) {
                //village_LBS(that);
                wx.openSetting({
                  success: function(data) {
                    console.log(data);
                    if (data.authSetting["scope.userLocation"] == true) {
                      wx.showToast({
                        title: '授权成功',
                        icon: 'success',
                        duration: 5000
                      })
                      //再次授权，调用getLocationt的API
                      village_LBS(that);
                    } else {
                      wx.showToast({
                        title: '授权失败',
                        icon: 'success',
                        duration: 5000
                      })
                    }
                  }
                })
              }
            }
          })
        } else if (res.authSetting['scope.userLocation'] == undefined) { //初始化进入
          village_LBS(that);
        }
      }
    })
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

/**
 * 用户点击右上角分享
 */
onShareAppMessage: function() {

}
})