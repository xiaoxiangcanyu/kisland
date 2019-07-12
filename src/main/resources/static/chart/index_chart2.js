$(function () {
    var myChart2 = echarts.init(document.getElementById('main1'));
    option = {
        title: {
            text: '车库车牌检测统计图'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'category',
                data: ['鲁A2838289', '鲁B4439837', '鲁C4322422','鲁A5632589','鲁A5632655','鲁A58996225','鲁B4362899'],
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '直接访问',
                type: 'bar',
                barWidth: '60%',
                itemStyle: {
                    normal: {
                        // 随机显示
                        //color:function(d){return "#"+Math.floor(Math.random()*(256*256*256-1)).toString(16);}

                        // 定制显示（按顺序）
                        color: function(params) {
                            var colorList = ['#C33531','#505F26','#2F4554','#D48265','#C23531', '#61A0A8','#2F4554'];
                            return colorList[params.dataIndex];
                        }
                    },
                },
                data: [2, 1, 2,2,2,2,3]
            }
        ]
    }
        myChart2.setOption(option);
})