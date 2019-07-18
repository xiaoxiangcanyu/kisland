var app = angular.module('myApp', ['ui.router', 'wui.date']);
app.config(['$stateProvider', function ($stateProvider) {
    $stateProvider
    //资金日报表路由
        .state('CapitalDailyTable', {
                url: '/CapitalDailyTable',
                controller: 'CapitalDailyTableController',
                views: {
                    "view-CapitalDailyTable": {
                        templateUrl: 'views/capital_daily_table.html'
                    }
                }
            }
        )
        //中国银行
        .state('ChinaBank', {
                url: '/ChinaBank',
                controller: 'ChinaBankController',
                params: {'companytitle': ""},
                views: {
                    "view-ChinaBank": {
                        templateUrl: 'views/china_bank.html'
                    }
                }
            }
        )
        //中国农业银行
        .state('AgriculturalBank', {
                url: '/AgriculturalBank',
                controller: 'AgriculturalBankController',
                params: {'companytitle': ""},
                views: {
                    "view-AgriculturalBank": {
                        templateUrl: 'views/agricultural_bank.html'
                    }
                }
            }
        )
        //中国工商银行
        .state('IndustrialAndCommercialBank', {
                url: '/IndustrialAndCommercialBank',
                controller: 'IndustrialAndCommercialBankController',
                params: {'companytitle': ""},
                views: {
                    "view-IndustrialAndCommercialBank": {
                        templateUrl: 'views/industrial_and_commercial_bank.html'
                    }
                }
            }
        )
        //中国建设银行
        .state('EconomicAndConstructionBank', {
                url: '/EconomicAndConstructionBank',
                controller: 'EconomicAndConstructionBankController',
                params: {'companytitle': ""},
                views: {
                    "view-EconomicAndConstructionBank": {
                        templateUrl: 'views/economic_construction_bank.html'
                    }
                }
            }
        )
        //中国民生银行
        .state('MinShengBank', {
                url: '/MinShengBank',
                controller: 'MinShengBankController',
                params: {'companytitle': ""},
                views: {
                    "view-MinShengBank": {
                        templateUrl: 'views/minsheng_bank.html'
                    }
                }
            }
        )
        //中国招商银行
        .state('MerchantsBank', {
                url: '/MerchantsBank',
                controller: 'MerchantsBankController',
                params: {'companytitle': ""},
                views: {
                    "view-MerchantsBank": {
                        templateUrl: 'views/merchants_bank.html'
                    }
                }
            }
        )
        //星展银行
        .state('DbsBank', {
            url: '/DbsBank',
            controller: 'DbsBankController',
            params: {'companytitle': ""},
            views: {
                "view-DbsBank": {
                    templateUrl: 'views/dbs_bank.html'
                }
            }
        })
        //成员管理
        .state('memberManagement', {
            url: '/memberManagement',
            controller: 'memberManagementController',
            views: {
                "view-memberManagement": {
                    templateUrl: 'views/member_management.html'
                }
            }
        })//权限管理
        .state('permissionManagement', {
            url: '/permissionManagement',
            controller: 'permissionManagementController',
            views: {
                "view-permissionManagement": {
                    templateUrl: 'views/permission_management.html'
                }
            }
        })
        //收款mapping
        .state('incomeMapping', {
            params: {"region": null},
            url: '/incomeMapping',
            controller: 'IncomeMappingController',
            views: {
                "view-incomeMapping": {
                    templateUrl: 'views/income_mapping.html'
                }
            }
        })
        //付款mapping
        .state('chargeMapping', {
            params: {"region": null},
            url: '/chargeMapping',
            controller: 'ChargeMappingController',
            views: {
                "view-chargeMapping": {
                    templateUrl: 'views/charge_mapping.html'
                }
            }
        })
        //余额查询界面
        .state('BankBalanceSearch', {
            url: '/BankBalanceSearch',
            controller: 'BankBalanceSearchController',
            views: {
                "view-BankBalanceSearch": {
                    templateUrl: 'views/bank_balance_search.html'
                }
            }
        })
}]);
//======================================Service===================================================
//=============================获取根据日期和公司名称选择银行========================================
app.factory('AjaxGetListByCompanyTitleAndDateService', function ($http, $q) {
    var factory = {};
    factory.GetList = function (url, companyName, startTime, endTime, method) {
        var defer = $q.defer();
        if (method === 'GET') {
            $http({
                method: 'GET',
                params: {'AccountTitle': companyName, 'StartDateTime': startTime, 'EndDateTime': endTime},
                url: '/' + url
            }).then(function successCallback(response) {
                defer.resolve(response.data)
            }, function errorCallback(response) {
                // 请求失败执行代码
                defer.reject("error")
            });
            return defer.promise;
        } else {
            $http({
                method: 'POST',
                params: {'AccountTitle': companyName, 'StartDateTime': startTime, 'EndDateTime': endTime},
                url: '/' + url
            }).then(function successCallback(response) {
                defer.resolve(response.data)
            }, function errorCallback(response) {
                // 请求失败执行代码
                defer.reject("error")
            });
            return defer.promise;
        }
    };
    return factory;
});
//=============================获取根据日期和公司名称选择银行========================================
//=============================资金日报表获取统计汇总===============================================
app.factory('AjaxGetCapitalStatisticsService', function ($http, $q) {
    var factory = {};
    factory.GetList = function (startTime, endTime) {
        console.log(startTime);
        console.log(endTime);
        var defer = $q.defer();
        $http({
            params: {'startTime': startTime, 'endTime': endTime},
            method: 'GET',
            url: '/CapitalStatisticsList'
        }).then(function successCallback(response) {
            defer.resolve(response.data)
        }, function errorCallback(response) {
            // 请求失败执行代码
            defer.reject("error")
        });
        return defer.promise;
    };
    return factory;
});
//=============================资金日报表获取统计汇总===============================================
//=============================资金日报表添加收款类型===============================================
app.factory('AddCategoryService', function ($http, $q) {
    var factory = {};
    factory.AddCategoryName = function (url, categoryname) {
        var defer = $q.defer();
        $http({
            method: 'POST',
            params: {'categoryname': categoryname},
            url: '/' + url
        }).then(function successCallback(response) {
            defer.resolve(response.data)
        }, function errorCallback(response) {
            // 请求失败执行代码
            defer.reject("error")
        });
        return defer.promise;
    };
    return factory;
});
//=============================资金日报表添加收款类型===============================================

//=============================资金日报表删除收款类型===============================================
app.factory('DeleteCategoryService', function ($http, $q) {
    var factory = {};
    factory.DeleteCategoryName = function (url, id) {
        var defer = $q.defer();
        console.log("id:" + id);
        $http({
            method: 'POST',
            params: {'Id': id},
            url: '/' + url
        }).then(function successCallback(response) {
            defer.resolve(response.data)
        }, function errorCallback(response) {
            // 请求失败执行代码
            defer.reject("error")
        });
        return defer.promise;
    };
    return factory;
});
//=====
//=============================资金日报表删除收款类型===============================================

//=============================收付款Mapping类型===================================================
app.factory('CommonAjax', function ($http, $q) {
    var factory = {};
    factory.getList = function (url, region) {
        var defer = $q.defer();
        $http({
            url: '/' + url,
            params: {'region': region},
        }).then(function successCallback(response) {
            defer.resolve(response.data)
        }, function errorCallback(response) {
            // 请求失败执行代码
            defer.reject("error")
        });
        return defer.promise;
    };
    return factory;
});
app.factory('AddAjax', function ($http, $q) {
    var factory = {};
    factory.AddIncome = function (url, domain) {
        console.log(domain);
        var defer = $q.defer();
        $http({
            method: 'POST',
            url: '/' + url,
            data: $.param(domain),
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        }).then(function successCallback(response) {
            defer.resolve(response.data)
        }, function errorCallback(response) {
            // 请求失败执行代码
            defer.reject("error")
        });
        return defer.promise;
    };
    return factory;
});
app.factory('DeleteAjax', function ($http, $q) {
    var factory = {};
    factory.deleteIncomeMapping = function (url, id) {
        var defer = $q.defer();
        $http({
            url: '/' + url,
            params: {'id': id},
        }).then(function successCallback(response) {
            defer.resolve(response.data)
        }, function errorCallback(response) {
            // 请求失败执行代码
            defer.reject("error")
        });
        return defer.promise;
    };
    return factory;
});
//=============================收付款Mapping类型===================================================
// ===============================分页===============================================================

app.service("PageReady", function () {
    var getPageparam;
    getPageparam = function (data, size, callback) {
        var totalPages;
        totalPages = Math.ceil(data.length / size);
        console.log("后台传过来一共:" + data.length + "条数据");
        console.log("每页:" + size + "条");
        console.log("一共要分:" + totalPages);
        return callback(totalPages);
    };
    return {
        getPageparam: getPageparam
    };
});
// ===============================分页===============================================================
// ===============================余额查询===============================================================
app.factory('SearchBankBalance', function ($http, $q) {
    var factory = {};
    factory.getList = function (startTime, endTime, accountTitle) {
        var defer = $q.defer();
        $http({
            params: {'startTime': startTime, 'endTime': endTime, 'accountTitle': accountTitle},
            url: '/SearchBankBalance',
        }).then(function successCallback(response) {
            defer.resolve(response.data)
        }, function errorCallback(response) {
            // 请求失败执行代码
            defer.reject("error")
        });
        return defer.promise;
    };
    return factory;
});
// ===============================余额查询===============================================================

//======================================Service===================================================

// ========================================Directive===================================================
app.directive('pagination', function ($rootScope) {
    return {
        restrict: 'AE',
        replace: true,
        template: '<ul class="pagination" style="height: 20px">' + '<li style="margin-right: 15px" ng-click="pageClick(p)" ng-repeat="p in page" class="{{option.curr==p?\'active\':\'\'}}">' + '<a href="javascript:;" rel="external nofollow" >{{p}}</a>' + '</li>' + '</ul>',
        scope: {
            data: '=',
            option: '=',
            mappinglist: '='
        },
        link: function ($scope) {
            var getRange;
            getRange = void 0;
            getRange = function (curr, all, count) {
                var from, i, range, to;
                from = void 0;
                i = void 0;
                range = void 0;
                to = void 0;
                curr = parseInt(curr);
                all = parseInt(all);
                count = parseInt(count);
                from = curr - parseInt(count / 2);
                to = curr + parseInt(count / 2) + count % 2 - 1;
                if (from <= 0) {
                    from = 1;
                    to = from + count - 1;
                    if (to > all) {
                        to = all;
                    }
                }
                if (to > all) {
                    to = all;
                    from = to - count + 1;
                    if (from <= 0) {
                        from = 1;
                    }
                }
                range = [];
                i = from;
                while (i <= to) {
                    range.push(i);
                    i++;
                }
                range.push('下一页', '>>', '末页');
                range.unshift('首页', '<<', '上一页');
                return range;
            };
            if (!$scope.option.curr || isNaN($scope.option.curr) || $scope.option.curr < 1) {
                $scope.option.curr = 1;
            }
            if ($scope.option.all === 0 || !$scope.option.all || isNaN($scope.option.all) || $scope.option.all < 1) {
                $scope.option.all = 1;
            }
            if ($scope.option.curr > $scope.option.all) {
                $scope.option.curr = $scope.option.all;
            }
            if (!$scope.option.count || isNaN($scope.option.count) || $scope.option.count < 1) {
                $scope.option.count = 15;
            }
            $scope.page = getRange($scope.option.curr, $scope.option.all, $scope.option.count);
            $scope.pageClick = function (page) {
                var fromdata, todata;
                if (page === '上一页') {
                    page = parseInt($scope.option.curr) - 1;
                } else if (page === '下一页') {
                    page = parseInt($scope.option.curr) + 1;
                } else if (page === '首页') {
                    page = 1;
                } else if (page === '末页') {
                    page = $scope.option.all;
                } else if (page === '<<') {
                    page = parseInt($scope.option.curr) - 15;
                } else if (page === '>>') {
                    page = parseInt($scope.option.curr) + 15;
                }
                if (page < 1) {
                    page = 1;
                } else if (page > $scope.option.all) {
                    page = $scope.option.all;
                }
                if (page === $scope.option.curr) {
                    return;
                }
                $scope.option.curr = page;
                $scope.page = getRange($scope.option.curr, $scope.option.all, $scope.option.count);
                fromdata = 0 + ($scope.option.curr - 1) * 15;
                todata = 15 + ($scope.option.curr - 1) * 15;
                $scope.mappinglist = $scope.data.slice(fromdata, todata);
            };
            $scope.$watch('option', (function (newValue, oldValue) {
                if (newValue === oldValue) {
                    return;
                }
                if (!$scope.option.curr || isNaN($scope.option.curr) || $scope.option.curr < 1) {
                    $scope.option.curr = 1;
                }
                if ($scope.option.all === 0 || !$scope.option.all || isNaN($scope.option.all) || $scope.option.all < 1) {
                    $scope.option.all = 1;
                }
                if ($scope.option.curr > $scope.option.all) {
                    $scope.option.curr = $scope.option.all;
                }
                if (!$scope.option.count || isNaN($scope.option.count) || $scope.option.count < 1) {
                    $scope.option.count = 15;
                }
                $scope.page = getRange($scope.option.curr, $scope.option.all, $scope.option.count);
            }), false);
        }
    };
});
// ========================================Directive===================================================

//资金日报表控制器
app.controller('CapitalDailyTableController', function ($scope, $state, $rootScope, $stateParams, AjaxGetCapitalStatisticsService, AddCategoryService, DeleteCategoryService) {
    $rootScope.errormessage = "";
    $rootScope.companyName = $stateParams.companytitle;
    $scope.incomecategoryname = "";
    $scope.chargecategoryname = "";
    $scope.startTime = "";
    $scope.endTime = "";
    // ======================================================可用资金===========================================================================
    $scope.BeginningLimitedFundKZL =  "";
    $scope.BeginningLimitedFundNorth = "";
    $scope.BeginningLimitedFundMid =  "";
    $scope.BeginningLimitedFundSouth =  "";
    $scope.BeginningLimitedFundSum = "";
    $scope.EndLimitedFundKZL = "";
    $scope.EndLimitedFundNorth =  "";
    $scope.EndLimitedFundMid = "";
    $scope.EndLimitedFundSouth = "";
    $scope.EndLimitedFundSum =  "";
    // ======================================================可用资金===========================================================================

    // ======================================================收款资金===========================================================================
    // ========================================================北区================================================================
    $scope.IncomeKZL = "";
    $scope.IncomeNorth = "";
    $scope.IncomeMid = "";
    $scope.IncomeSouth = "";
    $scope.IncomeSum =  "";
    // ========================================================北区================================================================
    // ======================================================收款资金===========================================================================

    // ======================================================付款资金===========================================================================
    // ========================================================北区================================================================
    $scope.ChargeKZL = "";
    $scope.ChargeNorth = "";
    $scope.ChargeMid = "";
    $scope.ChargeSouth = "";
    $scope.ChargeSum =  "";
    // ========================================================北区================================================================
    // ======================================================付款资金===========================================================================

    //查询起始日期和截止日期
    $scope.getCapitalDailyTableByStartAndEnd = function () {
        //初始化资金日报表
        AjaxGetCapitalStatisticsService.GetList($scope.startTime, $scope.endTime).then(function (result) {
            console.log(result);
            $scope.BeginningLimitedFundKZL = result['期初可用资金-凯知乐-凯知乐贸易（天津）有限公司'];
            $scope.BeginningLimitedFundNorth = result['期初可用资金-北区'];
            $scope.BeginningLimitedFundMid= result['期初可用资金-中区'];
            $scope.BeginningLimitedFundSouth = result['期初可用资金-南区'];
            $scope.BeginningLimitedFundSum = result['期初可用资金-总和'];

            $scope.EndLimitedFundKZL = result['期末可用资金-凯知乐-凯知乐贸易（天津）有限公司'];
            $scope.EndLimitedFundNorth = result['期末可用资金-北区'];
            $scope.EndLimitedFundMid= result['期末可用资金-中区'];
            $scope.EndLimitedFundSouth = result['期末可用资金-南区'];
            $scope.EndLimitedFundSum = result['期末可用资金-总和'];

            $scope.IncomeKZL = result['凯知乐收款'];
            $scope.IncomeNorth = result['北区收款'];
            $scope.IncomeMid = result['中区收款'];
            $scope.IncomeSouth = result['南区收款'];
            $scope.IncomeSum = result['收款总计'];
            $scope.IncomeStatisticList = JSON.parse(result['收款渠道']);

            $scope.ChargeKZL = result['凯知乐付款'];
            $scope.ChargeNorth = result['北区付款'];
            $scope.ChargeMid = result['中区付款'];
            $scope.ChargeSouth = result['南区付款'];
            $scope.ChargeSum = result['付款总计'];
            $scope.ChargeStatisticList = JSON.parse(result['付款渠道']);
        });
    };

    //添加收款类型
    $scope.AddIncomeCategory = function () {
        AddCategoryService.AddCategoryName("AddIncomeCategory", $scope.incomecategoryname).then(function (result) {
            console.log(result);
            if (result['result'] === 'success') {
                swal({
                    title: "Create Success!",
                    text: "收款类型添加成功",
                    icon: "success",
                    button: "Ok"
                });
                $('#AddIncomeCategoryModal').modal('hide');
                AjaxGetCapitalStatisticsService.GetList().then(function (result) {
                    $scope.IncomeStatisticList = result['Income'];
                    $scope.ChargeStatisticList = result['charge'];
                });
            }


        })
    };

    //删除收款类型
    $scope.DeleteIncomeCategory = function (id) {
        DeleteCategoryService.DeleteCategoryName("DeleteIncomeCategory", id).then(function (result) {
            console.log(result);
            if (result['result'] === 'success') {
                swal({
                    title: "Delete Success!",
                    text: "收款类型删除成功",
                    icon: "success",
                    button: "Ok"
                });
                AjaxGetCapitalStatisticsService.GetList().then(function (result) {
                    $scope.IncomeStatisticList = result['Income'];
                    $scope.ChargeStatisticList = result['charge'];
                });
            }


        })
    };
    //添加付款类型
    $scope.AddChargeCategory = function () {
        AddCategoryService.AddCategoryName("AddChargeCategory", $scope.chargecategoryname).then(function (result) {
            console.log(result);
            if (result['result'] === 'success') {
                swal({
                    title: "Create Success!",
                    text: "付款类型添加成功",
                    icon: "success",
                    button: "Ok"
                });
                $('#AddChargeCategoryModal').modal('hide');
                AjaxGetCapitalStatisticsService.GetList().then(function (result) {
                    $scope.IncomeStatisticList = result['Income'];
                    $scope.ChargeStatisticList = result['charge'];
                });
            }
        })
    };
    //删除付款类型
    //删除收款类型
    $scope.DeleteChargeCategory = function (id) {
        DeleteCategoryService.DeleteCategoryName("DeleteChargeCategory", id).then(function (result) {
            console.log(result);
            if (result['result'] === 'success') {
                swal({
                    title: "Delete Success!",
                    text: "付款类型删除成功",
                    icon: "success",
                    button: "Ok"
                });
                AjaxGetCapitalStatisticsService.GetList().then(function (result) {
                    $scope.IncomeStatisticList = result['Income'];
                    $scope.ChargeStatisticList = result['charge'];
                });
            }


        })
    };
});
app.controller('AppCtrl', function ($scope, $state) {
    $state.go('CapitalDailyTable');
});
//中国银行的控制器
app.controller('ChinaBankController', function ($scope, $rootScope, $http, $stateParams, $filter, AjaxGetListByCompanyTitleAndDateService,PageReady) {
    $scope.data = [];
    $scope.all = 0;
    $scope.current = 0;
    $scope.count = 15;
    $scope.option = {
        curr: $scope.current,
        all: $scope.all,
        count: $scope.count
    };
    $rootScope.companyName = $stateParams.companytitle;
    $scope.today = new Date();
    $scope.timeString = $filter('date')($scope.today, 'yyyy-MM-dd');
    $scope.startTime = "2019-06-01";
    $scope.endTime = $scope.timeString;
    $scope.startTime = "2019-06-01";
    $scope.endTime = $scope.timeString;
    //=======================================================初始化====================================================================================
    AjaxGetListByCompanyTitleAndDateService.GetList('findChinaBankByAccountTitleAndDate', $stateParams.companytitle, $scope.startTime, $scope.timeString, 'GET').then(function (result) {
        $scope.data = result;
        console.log(result)
        PageReady.getPageparam($scope.data, 15, function (totalPages) {
            var currentPageData;
            $scope.all = totalPages;
            $scope.option = {
                curr: $scope.current,
                all: $scope.all,
                count: $scope.count
            };
            currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
            return $scope.chinabankdata = currentPageData;
        });
    });
    //=======================================================初始化====================================================================================

    //=======================================================时间段查询====================================================================================
    $scope.getByStartAndEnd = function () {
        AjaxGetListByCompanyTitleAndDateService.GetList('findChinaBankByAccountTitleAndDate', $stateParams.companytitle, $scope.startTime, $scope.endTime, 'GET').then(function (result) {
            $scope.data = result;
            PageReady.getPageparam($scope.data, 15, function (totalPages) {
                var currentPageData;
                $scope.all = totalPages;
                $scope.option = {
                    curr: $scope.current,
                    all: $scope.all,
                    count: $scope.count
                };
                currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
                return $scope.chinabankdata = currentPageData;
            });
        });
    };
    //=======================================================时间段查询====================================================================================


});
//中国农业银行的控制器
app.controller('AgriculturalBankController', function ($scope, $rootScope, $http, $stateParams, $filter, AjaxGetListByCompanyTitleAndDateService,PageReady) {
    $scope.data = [];
    $scope.all = 0;
    $scope.current = 0;
    $scope.count = 15;
    $scope.option = {
        curr: $scope.current,
        all: $scope.all,
        count: $scope.count
    };
    $scope.today = new Date();
    $scope.timeString = $filter('date')($scope.today, 'yyyy-MM-dd');
    $rootScope.companyName = $stateParams.companytitle;
    $scope.startTime = "2019-06-01";
    $scope.endTime = $scope.timeString;
    //=======================================================初始化====================================================================================
    AjaxGetListByCompanyTitleAndDateService.GetList('findAgriculturalBankByAccountTitleAndDate', $stateParams.companytitle, $scope.startTime, $scope.timeString, 'GET').then(function (result) {
        $scope.data = result;
        PageReady.getPageparam($scope.data, 15, function (totalPages) {
            var currentPageData;
            $scope.all = totalPages;
            $scope.option = {
                curr: $scope.current,
                all: $scope.all,
                count: $scope.count
            };
            currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
            return $scope.agriculturalbankdata = currentPageData;
        });
    });
    //=======================================================初始化====================================================================================

    //=======================================================时间段查询====================================================================================
    $scope.getByStartAndEnd = function () {
        AjaxGetListByCompanyTitleAndDateService.GetList('findAgriculturalBankByAccountTitleAndDate', $stateParams.companytitle, $scope.startTime, $scope.endTime, 'GET').then(function (result) {
            $scope.data = result;
            PageReady.getPageparam($scope.data, 15, function (totalPages) {
                var currentPageData;
                $scope.all = totalPages;
                $scope.option = {
                    curr: $scope.current,
                    all: $scope.all,
                    count: $scope.count
                };
                currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
                return $scope.agriculturalbankdata = currentPageData;
            });
        });
    };
    //=======================================================时间段查询====================================================================================

});
//中国工商银行的控制器
app.controller('IndustrialAndCommercialBankController', function ($scope, $rootScope, $http, $stateParams, $filter, AjaxGetListByCompanyTitleAndDateService,PageReady) {
    $scope.data = [];
    $scope.all = 0;
    $scope.current = 0;
    $scope.count = 15;
    $scope.option = {
        curr: $scope.current,
        all: $scope.all,
        count: $scope.count
    };
    $scope.today = new Date();
    $scope.timeString = $filter('date')($scope.today, 'yyyy-MM-dd');
    $rootScope.companyName = $stateParams.companytitle;
    $scope.startTime = "2019-06-01";
    $scope.endTime = $scope.timeString;
    //=======================================================初始化====================================================================================
    AjaxGetListByCompanyTitleAndDateService.GetList('findIndustrialAndCommercialBankByAccountTitleAndDate', $stateParams.companytitle, $scope.startTime, $scope.timeString, 'GET').then(function (result) {
        $scope.data = result;
        PageReady.getPageparam($scope.data, 15, function (totalPages) {
            var currentPageData;
            $scope.all = totalPages;
            $scope.option = {
                curr: $scope.current,
                all: $scope.all,
                count: $scope.count
            };
            currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
            return $scope.industrialandcommercialbankdata = currentPageData;
        });
    });
    //=======================================================初始化====================================================================================

    //=======================================================时间段查询====================================================================================
    $scope.getByStartAndEnd = function () {
        AjaxGetListByCompanyTitleAndDateService.GetList('findIndustrialAndCommercialBankByAccountTitleAndDate', $stateParams.companytitle, $scope.startTime, $scope.endTime, 'GET').then(function (result) {
            $scope.data = result;
            PageReady.getPageparam($scope.data, 15, function (totalPages) {
                var currentPageData;
                $scope.all = totalPages;
                $scope.option = {
                    curr: $scope.current,
                    all: $scope.all,
                    count: $scope.count
                };
                currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
                return $scope.industrialandcommercialbankdata = currentPageData;
            });
        });
    };
    //=======================================================时间段查询====================================================================================


});
//中国建设银行的控制器
app.controller('EconomicAndConstructionBankController', function ($scope, $rootScope, $http, $stateParams, $filter, AjaxGetListByCompanyTitleAndDateService,PageReady) {
    $scope.data = [];
    $scope.all = 0;
    $scope.current = 0;
    $scope.count = 15;
    $scope.option = {
        curr: $scope.current,
        all: $scope.all,
        count: $scope.count
    };
    $scope.today = new Date();
    $scope.timeString = $filter('date')($scope.today, 'yyyy-MM-dd');
    $rootScope.companyName = $stateParams.companytitle;
    $scope.startTime = "2019-06-01";
    $scope.endTime = $scope.timeString;
    //=======================================================初始化====================================================================================
    AjaxGetListByCompanyTitleAndDateService.GetList('findEconomicConstructionBankByAccountTitleAndDate', $stateParams.companytitle, $scope.startTime, $scope.timeString, 'GET').then(function (result) {
        $scope.data = result;
        PageReady.getPageparam($scope.data, 15, function (totalPages) {
            var currentPageData;
            $scope.all = totalPages;
            $scope.option = {
                curr: $scope.current,
                all: $scope.all,
                count: $scope.count
            };
            currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
            return $scope.economicandconstructionbank = currentPageData;
        });

    });
    //=======================================================初始化====================================================================================

    //=======================================================时间段查询====================================================================================
    $scope.getByStartAndEnd = function () {
        AjaxGetListByCompanyTitleAndDateService.GetList('findEconomicConstructionBankByAccountTitleAndDate', $stateParams.companytitle, $scope.startTime, $scope.endTime, 'GET').then(function (result) {
            $scope.data = result;
            PageReady.getPageparam($scope.data, 15, function (totalPages) {
                var currentPageData;
                $scope.all = totalPages;
                $scope.option = {
                    curr: $scope.current,
                    all: $scope.all,
                    count: $scope.count
                };
                currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
                return $scope.economicandconstructionbank = currentPageData;
            });
        });
    };
    //=======================================================时间段查询====================================================================================
});
//中国民生银行的控制器
app.controller('MinShengBankController', function ($scope, $rootScope, $http, $stateParams, $filter, AjaxGetListByCompanyTitleAndDateService,PageReady) {
    $scope.data = [];
    $scope.all = 0;
    $scope.current = 0;
    $scope.count = 15;
    $scope.option = {
        curr: $scope.current,
        all: $scope.all,
        count: $scope.count
    };
    $scope.today = new Date();
    $scope.timeString = $filter('date')($scope.today, 'yyyy-MM-dd');
    $rootScope.companyName = $stateParams.companytitle;
    $scope.startTime = "2019-06-01";
    $scope.endTime = $scope.timeString;
    //=======================================================初始化====================================================================================
    AjaxGetListByCompanyTitleAndDateService.GetList('findMinshengBankByAccountTitleAndDate', $stateParams.companytitle, $scope.startTime, $scope.timeString, 'GET').then(function (result) {
        $scope.data = result;
        PageReady.getPageparam($scope.data, 15, function (totalPages) {
            var currentPageData;
            $scope.all = totalPages;
            $scope.option = {
                curr: $scope.current,
                all: $scope.all,
                count: $scope.count
            };
            currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
            return $scope.minshengbankdata = currentPageData;
        });
    });
    //=======================================================初始化====================================================================================

    //=======================================================时间段查询====================================================================================
    $scope.getByStartAndEnd = function () {
        AjaxGetListByCompanyTitleAndDateService.GetList('findMinshengBankByAccountTitleAndDate', $stateParams.companytitle, $scope.startTime, $scope.endTime, 'GET').then(function (result) {
            $scope.data = result;
            PageReady.getPageparam($scope.data, 15, function (totalPages) {
                var currentPageData;
                $scope.all = totalPages;
                $scope.option = {
                    curr: $scope.current,
                    all: $scope.all,
                    count: $scope.count
                };
                currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
                return $scope.minshengbankdata = currentPageData;
            });
        });
    };
    //=======================================================时间段查询====================================================================================
});
//中国招商银行的控制器
app.controller('MerchantsBankController', function ($scope, $rootScope, $http, $stateParams, $filter, AjaxGetListByCompanyTitleAndDateService, PageReady) {
    $scope.data = [];
    $scope.all = 0;
    $scope.current = 0;
    $scope.count = 15;
    $scope.option = {
        curr: $scope.current,
        all: $scope.all,
        count: $scope.count
    };
    $scope.today = new Date();
    $scope.timeString = $filter('date')($scope.today, 'yyyy-MM-dd');
    $rootScope.companyName = $stateParams.companytitle;
    $scope.startTime = "2019-06-01";
    $scope.endTime = $scope.timeString;
    //=======================================================初始化====================================================================================
    AjaxGetListByCompanyTitleAndDateService.GetList('findMerchantsBankByAccountTitleAndDate', $stateParams.companytitle, $scope.startTime, $scope.timeString, 'GET').then(function (result) {
        $scope.data = result;
        PageReady.getPageparam($scope.data, 15, function (totalPages) {
            var currentPageData;
            $scope.all = totalPages;
            $scope.option = {
                curr: $scope.current,
                all: $scope.all,
                count: $scope.count
            };
            currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
            return $scope.merchantsbankdata = currentPageData;
        });
    });
    //=======================================================初始化====================================================================================

    //=======================================================时间段查询====================================================================================
    $scope.getByStartAndEnd = function () {
        AjaxGetListByCompanyTitleAndDateService.GetList('findMerchantsBankByAccountTitleAndDate', $stateParams.companytitle, $scope.startTime, $scope.endTime, 'GET').then(function (result) {
            $scope.data = result;
            PageReady.getPageparam($scope.data, 15, function (totalPages) {
                var currentPageData;
                $scope.all = totalPages;
                $scope.option = {
                    curr: $scope.current,
                    all: $scope.all,
                    count: $scope.count
                };
                currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
                return $scope.merchantsbankdata = currentPageData;
            });
        });
    };
    //=======================================================时间段查询====================================================================================
});
//星展银行的控制器
app.controller('DbsBankController', function ($scope, $rootScope, $http, $stateParams, $filter, AjaxGetListByCompanyTitleAndDateService, PageReady) {
    $scope.data = [];
    $scope.all = 0;
    $scope.current = 0;
    $scope.count = 15;
    $scope.option = {
        curr: $scope.current,
        all: $scope.all,
        count: $scope.count
    };
    $scope.today = new Date();
    $scope.timeString = $filter('date')($scope.today, 'yyyy-MM-dd');
    $rootScope.companyName = $stateParams.companytitle;
    $scope.startTime = "2019-06-01";
    $scope.endTime = $scope.timeString;
    //=======================================================初始化分页查询====================================================================================
    AjaxGetListByCompanyTitleAndDateService.GetList('findDbsBankByAccountTitleAndDate', $stateParams.companytitle, $scope.startTime, $scope.timeString, 'GET').then(function (result) {
        $scope.data = result;
        PageReady.getPageparam($scope.data, 15, function (totalPages) {
            var currentPageData;
            $scope.all = totalPages;
            $scope.option = {
                curr: $scope.current,
                all: $scope.all,
                count: $scope.count
            };
            currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
            return $scope.Dbsbankdata = currentPageData;
        });

    });
    //=======================================================初始化====================================================================================

    //=======================================================时间段分页查询====================================================================================
    $scope.getByStartAndEnd = function () {
        AjaxGetListByCompanyTitleAndDateService.GetList('findDbsBankByAccountTitleAndDate', $stateParams.companytitle, $scope.startTime, $scope.endTime, 'GET').then(function (result) {
            $scope.data = result;
            PageReady.getPageparam($scope.data, 15, function (totalPages) {
                var currentPageData;
                $scope.all = totalPages;
                $scope.option = {
                    curr: $scope.current,
                    all: $scope.all,
                    count: $scope.count
                };
                currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
                return $scope.Dbsbankdata = currentPageData;
            });
        });
    };
    //=======================================================时间段查询====================================================================================
});
app.controller('IncomeMappingController', function ($scope, CommonAjax, AddAjax, PageReady, $stateParams, DeleteAjax) {
    $scope.incomemappinglist = null;//要显示的数据项，需要在页面中迭代显示
    $scope.data = [];
    $scope.all = 0;
    $scope.current = 0;
    $scope.count = 15;
    $scope.option = {
        curr: $scope.current,
        all: $scope.all,
        count: $scope.count,
    };
    //创建对象和属性
    $scope.incomemappingdomain = {
        "legelMajority": "",
        "bankAccount": "",
        "bankNumber": "",
        "otherAccountName": "",
        "tradeAbstract": "",
        "receivingChannel": "",
        "tradeScope": $stateParams.region
    };
    //获取收款规则列表
    CommonAjax.getList('getAllIncomeMapping', $stateParams.region).then(function (result) {
        $scope.data = result;
        PageReady.getPageparam($scope.data, 15, function (totalPages) {
            var currentPageData;
            $scope.all = totalPages;
            $scope.option = {
                curr: $scope.current,
                all: $scope.all,
                count: $scope.count
            };
            currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
            return $scope.incomemappinglist = currentPageData;
        });
    });
    // ===============================分页==========================================
    PageReady.getPageparam($scope.data, 15, function (totalPages) {
        var currentPageData;
        $scope.all = totalPages;
        $scope.option = {
            curr: $scope.current,
            all: $scope.all,
            count: $scope.count
        };
        currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
        return $scope.incomemappinglist = currentPageData;
    });

    //添加收款规则
    $scope.addIncomeMapping = function () {
        AddAjax.AddIncome('addIncomeMapping', $scope.incomemappingdomain).then(function (result) {
            if (result['result'] === 'success') {
                swal({
                    title: "Create Success!",
                    text: "收款Mapping添加成功",
                    icon: "success",
                    button: "Ok"
                });
                $('#AddIncomeMappingModal').modal('hide');
                //获取收款规则列表
                CommonAjax.getList('getAllIncomeMapping', $stateParams.region).then(function (result) {
                    $scope.data = result;
                    PageReady.getPageparam($scope.data, 15, function (totalPages) {
                        var currentPageData;
                        $scope.all = totalPages;
                        $scope.option = {
                            curr: $scope.current,
                            all: $scope.all,
                            count: $scope.count
                        };
                        currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
                        return $scope.incomemappinglist = currentPageData;
                    });
                });
            }
        })
    };
    //删除收款规则
    $scope.deleteIncomeMapping = function (id) {
        DeleteAjax.deleteIncomeMapping('deleteIncomeMapping', id).then(function (result) {
            if (result['result'] === 'success') {
                swal({
                    title: "Create Success!",
                    text: "收款Mapping删除成功",
                    icon: "success",
                    button: "Ok"
                });
                //获取收款规则列表
                CommonAjax.getList('getAllIncomeMapping', $stateParams.region).then(function (result) {
                    $scope.data = result;
                    PageReady.getPageparam($scope.data, 15, function (totalPages) {
                        var currentPageData;
                        $scope.all = totalPages;
                        $scope.option = {
                            curr: $scope.current,
                            all: $scope.all,
                            count: $scope.count
                        };
                        currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
                        return $scope.incomemappinglist = currentPageData;
                    });
                });
            }
        });

    }
});
app.controller('ChargeMappingController', function ($scope, CommonAjax, AddAjax, DeleteAjax, $stateParams, PageReady) {
    $scope.chargemappinglist = null;//要显示的数据项，需要在页面中迭代显示
    $scope.data = [];
    $scope.all = 0;
    $scope.current = 0;
    $scope.count = 15;
    $scope.option = {
        curr: $scope.current,
        all: $scope.all,
        count: $scope.count
    };
    //创建对象和属性
    $scope.chargemappingdomain = {
        "legelmajority": "",
        "bankaccount": "",
        "banknumber": "",
        "otheraccountName": "",
        "tradeabstract": "",
        "expendproject": "",
        "tradescope": $stateParams.region
    };
    CommonAjax.getList('getAllChargeMapping', $stateParams.region).then(function (result) {
        $scope.data = result;
        PageReady.getPageparam($scope.data, 15, function (totalPages) {
            var currentPageData;
            $scope.all = totalPages;
            $scope.option = {
                curr: $scope.current,
                all: $scope.all,
                count: $scope.count
            };
            currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
            return $scope.chargemappinglist = currentPageData;
        });
    });
    // ===============================分页==========================================

    PageReady.getPageparam($scope.data, 15, function (totalPages) {
        var currentPageData;
        $scope.all = totalPages;
        $scope.option = {
            curr: $scope.current,
            all: $scope.all,
            count: $scope.count
        };
        currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
        return $scope.chargemappinglist = currentPageData;
    });

    //添加付款规则
    $scope.addChargeMapping = function () {
        AddAjax.AddIncome('addChargeMapping', $scope.chargemappingdomain).then(function (result) {
            if (result['result'] === 'success') {
                swal({
                    title: "Create Success!",
                    text: "付款Mapping添加成功",
                    icon: "success",
                    button: "Ok"
                });
                $('#AddChargeMappingModal').modal('hide');
                //获取收款规则列表
                CommonAjax.getList('getAllChargeMapping', $stateParams.region).then(function (result) {
                    $scope.data = result;
                    PageReady.getPageparam($scope.data, 15, function (totalPages) {
                        var currentPageData;
                        $scope.all = totalPages;
                        $scope.option = {
                            curr: $scope.current,
                            all: $scope.all,
                            count: $scope.count
                        };
                        currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
                        return $scope.chargemappinglist = currentPageData;
                    });
                });
            }
        })
    };
    //删除付款规则
    $scope.deleteChargeMapping = function (id) {
        DeleteAjax.deleteIncomeMapping('deleteChargeMapping', id).then(function (result) {
            if (result['result'] === 'success') {
                swal({
                    title: "Create Success!",
                    text: "付款Mapping删除成功",
                    icon: "success",
                    button: "Ok"
                });
                //获取付款规则列表
                CommonAjax.getList('getAllChargeMapping', $stateParams.region).then(function (result) {
                    $scope.data = result;
                    PageReady.getPageparam($scope.data, 15, function (totalPages) {
                        var currentPageData;
                        $scope.all = totalPages;
                        $scope.option = {
                            curr: $scope.current,
                            all: $scope.all,
                            count: $scope.count
                        };
                        currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
                        return $scope.chargemappinglist = currentPageData;
                    });
                });
            }
        });

    }
});
app.controller('memberManagementController', function ($scope) {

});
app.controller('permissionManagementController', function ($scope) {

});
app.controller('BankBalanceSearchController', function ($scope, SearchBankBalance, $filter, PageReady) {
    $scope.data = [];
    $scope.all = 0;
    $scope.current = 0;
    $scope.count = 15;
    $scope.option = {
        curr: $scope.current,
        all: $scope.all,
        count: $scope.count
    };
    $scope.timeString = $filter('date')(new Date(), 'yyyy-MM-dd');
    $scope.startTime = "2019-06-01";
    $scope.endTime = $scope.timeString;
    $scope.accountTitle = '所有公司';
    //初始化分页
    SearchBankBalance.getList($scope.startTime, $scope.endTime, $scope.accountTitle).then(function (result) {
        $scope.data = result;
        PageReady.getPageparam($scope.data, 15, function (totalPages) {
            var currentPageData;
            $scope.all = totalPages;
            $scope.option = {
                curr: $scope.current,
                all: $scope.all,
                count: $scope.count
            };
            currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
            return $scope.bankbalancedata = currentPageData;
        });
    });
    //查询分页
    $scope.getByStartAndEndAndTitle = function () {
        SearchBankBalance.getList($scope.startTime, $scope.endTime, $scope.accountTitle).then(function (result) {
            $scope.data = result;
            PageReady.getPageparam($scope.data, 15, function (totalPages) {
                var currentPageData;
                $scope.all = totalPages;
                $scope.option = {
                    curr: $scope.current,
                    all: $scope.all,
                    count: $scope.count
                };
                currentPageData = $scope.data.slice(0 + $scope.current * 15, 15 + $scope.current * 15);
                return $scope.bankbalancedata = currentPageData;
            });
        });
    }

});