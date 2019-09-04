<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${title}</title>
    <!-- ZUI 标准版压缩后的 CSS 文件 -->
    <link rel="stylesheet" href="../static/zui/css/zui.min.css">


</head>
<body>
<div class="container">
    <article class="article article-condensed">
        <!-- 文章头部 -->
        <header>
            <h1>${title}</h1>
            <div class="row">
                <div class="col-xs-12">
                    <span style="color: #576b95;margin-left: 15px;">${companyName}</span>
                </div>

            </div>
            <#if remark?? && remark != "">
            <div class="row abstract" style="margin-top: 20px;">
                <div class="col-xs-12">
                    <p>${remark}</p>
                </div>
            </div>
            </#if>
        </header>
        <!-- 文章正文部分 -->
        <div class="content">
        ${content}
        </div>
        <!-- 文章底部 -->
        <footer>
            <div class="row" style="padding: 10px;">
                <div class="col-xs-6">
                    <div class="pull-left">阅读<span style="margin-left: 5px;" id="viewCount">${viewCount}</span> </div>
                    <input type="hidden" id="articleId" value="${articleId}">
                </div>
                <div class="col-xs-6">
                    <span class="pull-right">${praiseCount}<i class="icon-thumbs-o-up"
                                                              style="margin-left: 5px;"></i></span>
                </div>
            </div>
        </footer>

    </article>
</div>


<!-- ZUI Javascript 依赖 jQuery -->
<!--<script src="http://cdn.bootcss.com/zui/1.8.1/lib/jquery/jquery.js"></script>-->
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<!-- ZUI 标准版压缩后的 JavaScript 文件 -->
<script src="../static/zui/js/zui.min.js"></script>
<script>
    var articleId = $("#articleId").val();
    $.ajax({
        url:'http://admin.konglongri.cn/cms/api/article/getArticleinfo',
        type:'GET',  // 默认为GET
        data:{
            articleId:articleId
        },
        timeout:5000, // 超时时间
        success:function(result){
            console.log(result);
            if (result.success){
                var viewCount = result.data.viewCount;
                $("#viewCount").text(viewCount);
            }
        },
    })
</script>
</body>
</html>
