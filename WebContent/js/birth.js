//生日联动
$(function() {
    //年月日点击显示下拉菜单
    $('div.group div.txt div.sel input').click(function(e) {
        e.stopPropagation();
        if ($(this).attr('data-id') == '1') {
            $(this).attr('data-id', '0').css('background-image', 'url("less.png")').siblings('ul').css('top', '30px').stop().animate({
                'height': '160px',
            }, 500);
            $(this).parent().siblings().find('ul').css('top', '28px').stop().animate({ 'height': '0px', }, 500).siblings('input').attr('data-id', '1').css('background-image', 'url("more.png")');
        } else {
            $(this).attr('data-id', '1').css('background-image', 'url("more.png")').siblings('ul').css('top', '28px').stop().animate({
                    'height': '0px',
                },
                500);
        }
    });
    //点击选中下拉框中的值并赋值
    $('div.group div.txt').delegate('div.sel ul li', 'click', function(e) {
        e.stopPropagation();
        var $html = $(this).html();
        $(this).parent().css('top', '28px').animate({
            'height': '0px',
        }, 500).siblings('input').val($html).attr('data-id', '1').css('background-image', 'url("more.png")');
        if ($(this).parent().parent().hasClass('mon')) {
            $(this).parent().parent().siblings('.date').find('input').val('').siblings('ul').scrollTop(0);
            MMDD();
        }
        if ($(this).parent().parent().hasClass('year')) {
            $(this).parent().parent().siblings('.date').find('input').val('').siblings('ul').scrollTop(0);
            MMDD();
        }
    });
 
    /*给年月日下拉菜单赋值*/
    initial();
    //点击其他地方隐藏当前显示的下拉框
    $('body').click(function() {
        var obj = $('div.group div.txt div.sel ul');
        obj.each(function() {
            $(this).stop().animate({ 'height': '0px', }, 500).siblings('input').attr('data-id', '1').css('background-image', 'url("more.png")');
        });
    });
})
 
function initial() {
    /*给年月日下拉菜单赋值*/
    var MonHead = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    //先给年下拉框赋内容   
    var y = new Date().getFullYear();
    var min = y - 50;
    var max = y;
    for (var i = 0; i < 50; i++) {
        var $html = '<li>' + min + '年</li>';
        $('div.birth div.txt div.year ul').get(0).innerHTML += $html;
        min++;
    }
    //给月份下拉菜单赋值
    for (var i = 1; i < 13; i++) {
        var $html = '<li>' + i + '月</li>';
        $('div.birth div.txt div.mon ul').get(0).innerHTML += $html;
    }
    //给月份下拉菜单赋值
    writeDay(31);
}
//月发生变化时日期联动  
function MMDD() {
    var mon = parseInt($('div.birth div.txt div.mon input').val());
    var year = parseInt($('div.birth div.txt div.year input').val());
 
    if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12) {
        writeDay(31);
    } else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
        writeDay(30);
    } else if (mon == 2) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            writeDay(29);
        } else {
            writeDay(28);
        }
    }
}
//据条件写日期的下拉框
function writeDay(n) {
    //首先清空下拉菜单
    var obj = $('div.birth div.txt div.date ul');
    obj.html("");
    for (var i = 1; i < (n + 1); i++) {
        var $html = '<li>' + i + '日</li>';
        obj.get(0).innerHTML += $html;
    }
}
//判断是否闰平年
function IsPinYear(year) {
    return (0 == year % 4 && (year % 100 != 0 || year % 400 == 0));
}
