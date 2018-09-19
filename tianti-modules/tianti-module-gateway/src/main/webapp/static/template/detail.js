jc.data.setup(function (data) {
    var html = '';

    html += '<div class="d_header">';
    html += '<div class="h_title">' + this.getString(data.title) + '</div>';
    html += '<div class="h_intro">';
    html += '<span style="color:#576b95">' + (this.getString(data.publisher)) + '</span>';
    html += '<span>' + (jc.tools.formatDate(data.createDate, 'yyyy-MM-dd hh:mm:ss')) + '</span>';
    /* html += '<span>编辑于：' + (jc.tools.formatDate(data.updateDate, 'yyyy-MM-dd hh:mm:ss')) + '</span>';*/
    /* html += '<span>查看次数：' + (data.viewCount) + '次</span>';*/
    html += '</div>';
    html += '</div>';
    html += '<div class="d_main">';

    var content = this.getString(data.content);

    html += content;
    html += '</div>';
    html += '<div class="d_footer">';
    html += '<div class="f_left">';
    html += '<span>阅读 ' + (data.viewCount) + '</span>';
    /*html += '<a data-type="prev" href="javascript:;">上一篇</a>';*/
    html += '</div>';
    html += '<div class="f_right">';
    html += '<img id="dz" style="width:15px;float:right;color:#afafaf;font-size:14px;margin-top:2px;" src="../../resourse/img/86134-200.png" class="loading" data-was-processed="true"> <span style="clear: both;">赞</span></div>';
    html += '</div>';
    html += '</div>';


    return html;

});