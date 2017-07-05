<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="ch">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="CoreUI - Open Source Bootstrap Admin Template">
    <meta name="author" content="Łukasz Holeczek">
    <meta name="keyword" content="Bootstrap,Admin,Template,Open,Source,AngularJS,Angular,Angular2,jQuery,CSS,HTML,RWD,Dashboard">
    <link rel="shortcut icon" href="images/smalllogo.png">

    <title>车辆缉查布控系统</title>

    <!-- Icons -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/simple-line-icons.css" rel="stylesheet">

    <!-- Main styles for this application -->
    <link href="css/style.css" rel="stylesheet">

</head>

<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden">
    <header class="app-header navbar">
        <button class="navbar-toggler mobile-sidebar-toggler hidden-lg-up" type="button">☰</button>
        <a class="navbar-brand" href="#" ><img alt="logo" src="images/tinylogo.png"></a>
        <ul class="nav navbar-nav ml-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle nav-link" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    <img src="images/avatars/6.jpg" class="img-avatar" alt="admin@bootstrapmaster.com">
                    <span class="hidden-md-down">admin</span>
                </a>
                <div class="dropdown-menu dropdown-menu-right">

                    <div class="divider"></div>
                    <a class="dropdown-item" href="#"><i class="fa fa-shield"></i> 更改资料</a>
                    <a class="dropdown-item" href="#"><i class="fa fa-lock"></i> 注销</a>
                </div>
            </li>
            <li class="nav-item hidden-md-down">
                <a class="nav-link navbar-toggler aside-menu-toggler" >☰</a>
            </li>

        </ul>
    </header>

    <div class="app-body">
        <div class="sidebar">
            <nav class="sidebar-nav">
                <ul class="nav">

                    <li class="nav-item nav-dropdown">
                        <a class="nav-link nav-dropdown-toggle" href="#"><i class="icon-social-instagram "></i> 卡口系统</a>
                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a class="nav-link" href="components-buttons.html"> 过车信息查询</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="components-social-buttons.html"> 车辆轨迹回放</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="components-cards.html"> 卡口设备管理</a>
                            </li>
                            </ul>
                    </li>
                    <li class="nav-item nav-dropdown">
                        <a class="nav-link nav-dropdown-toggle" href="#"><i class="icon-user "></i> 黑名单布控</a>
                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a class="nav-link" href="icons-font-awesome.html"> 黑名单布控申请</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="icons-simple-line-icons.html"> 黑名单布控审核</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="icons-font-awesome.html"> 黑名单布控管理</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="icons-simple-line-icons.html"> 黑名单报警处理</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="icons-font-awesome.html"> 黑名单布控撤销</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="icons-simple-line-icons.html"> 黑名单综合查询</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="icons-font-awesome.html"> 黑名单报警查询</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item nav-dropdown">
                        <a class="nav-link nav-dropdown-toggle" href="#"><i class="icon-compass "></i> 资源管理</a>
                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a class="nav-link" href="components-buttons.html"> 点位管理</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="components-social-buttons.html"> 道路管理</a>
                            </li>
                            </ul>
                    </li>
                    <li class="nav-item nav-dropdown">
                        <a class="nav-link nav-dropdown-toggle" href="#"><i class="icon-magnifier "></i> 系统管理</a>
                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a class="nav-link" href="components-buttons.html"> 部门管理</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="components-social-buttons.html"> 角色管理</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="components-cards.html"> 人员管理管理</a>
                            </li>
                            </ul>
                    </li>
                    <li class="divider"></li>

                </ul>
            </nav>
        </div>

        <!-- Main content -->
        <main class="main">

            <div class="container-fluid">

                <div class="animated fadeIn">
                </div>

            </div>
            <!-- /.conainer-fluid -->
        </main>


    </div>

    <footer class="app-footer">
        <a href="#" style = "position: relative;left:85%">CoreUI</a> <a style = "position: relative;left:85%">© 2017 creativeLabs.</a>
    </footer>

    <!-- Bootstrap and necessary plugins -->
    <script src="assets/vendor/jquery/jquery.min.js"></script>
    <script src="js/tether.min.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="js/pace.min.js"></script>


    <!-- Plugins and scripts required by all views -->
    <script src="js/Chart.min.js"></script>


    <!-- GenesisUI main scripts -->

    <script src="js/app.js"></script>

    <!-- Plugins and scripts required by this views -->

    <!-- Custom scripts required by this view -->
    <script src="js/views/main.js"></script>

</body>

</html>