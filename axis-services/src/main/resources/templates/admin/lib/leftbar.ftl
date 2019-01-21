<#macro nav>
<!-- ============================================================== -->
<!-- Left Sidebar - style you can find in sidebar.scss  -->
<!-- ============================================================== -->
<aside class="left-sidebar">
    <!-- Sidebar scroll-->
    <div class="scroll-sidebar">
        <!-- Sidebar navigation-->
        <nav class="sidebar-nav">
            <ul id="sidebarnav">
                <li class="user-pro"> <a class="has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false"><img src="../assets/images/users/user.jpeg" alt="user-img" class="img-circle"><span class="hide-menu">${principal}</span></a>
                    <ul aria-expanded="false" class="collapse">
                        <li><a href="javascript:void(0)"><i class="ti-user"></i> My Profile</a></li>
                        <li><a href="javascript:void(0)"><i class="ti-wallet"></i> My Balance</a></li>
                        <li><a href="javascript:void(0)"><i class="ti-email"></i> Inbox</a></li>
                        <li><a href="javascript:void(0)"><i class="ti-settings"></i> Account Setting</a></li>
                        <li><a href="#" onclick="document.forms['logoutForm'].submit();return false;"><i class="fa fa-power-off"></i> Logout</a></li>
                    </ul>
                </li>
                <li> <a class="has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false"><i class="icon-speedometer"></i><span class="hide-menu">Dashboard <span class="badge badge-pill badge-cyan ml-auto">4</span></span></a>
                    <ul aria-expanded="false" class="collapse">
                        <li><a href="index.html">Minimal </a></li>
                        <li><a href="index2.html">Analytical</a></li>
                        <li><a href="index3.html">Demographical</a></li>
                        <li><a href="index4.html">Modern</a></li>
                    </ul>
                </li>
                <li> <a class="has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="true"><i class="fas fa-keyboard"></i><span class="hide-menu">SOR</span></a>
                    <ul aria-expanded="false" class="collapse">
                        <li><a href="/orders/create">Order Entry</a></li>
                        <li><a href="form-layout.html">Validation</a></li>
                        <li><a href="form-addons.html">Completed</a></li>
                        <li><a href="form-basic.html">Exportable list</a></li>
                        <li><a href="form-layout.html">Dashboard</a></li>
                    </ul>
                </li>
                <li> <a class="has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="true"><i class="fas fa-diagnoses"></i><span class="hide-menu">RFT</span></a>
                    <ul aria-expanded="false" class="collapse">
                        <li><a href="layout-fix-header.html">Tracking</a></li>
                        <li><a href="layout-fix-sidebar.html">Completed</a></li>
                        <li><a href="form-basic.html">Exportable list</a></li>
                        <li><a href="form-layout.html">Dashboard</a></li>
                    </ul>
                </li>
                <li> <a class="has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="true"><i class="fas fa-edit"></i><span class="hide-menu">AQN</span></a>
                    <ul aria-expanded="false" class="collapse">
                        <li><a href="layout-fix-header.html">Tracking</a></li>
                        <li><a href="layout-fix-sidebar.html">Sold</a></li>
                        <li><a href="form-basic.html">Exportable list</a></li>
                        <li><a href="form-layout.html">Dashboard</a></li>
                    </ul>
                </li>
                <li> <a class="has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="true"><i class="fas fa-dolly-flatbed"></i><span class="hide-menu">ASO</span></a>
                    <ul aria-expanded="false" class="collapse">
                        <li><a href="layout-fix-header.html">Tracking</a></li>
                        <li><a href="layout-fix-sidebar.html">Completed</a></li>
                        <li><a href="form-basic.html">Exportable list</a></li>
                        <li><a href="form-layout.html">Dashboard</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <!-- End Sidebar navigation -->
    </div>
    <!-- End Sidebar scroll-->
</aside>
<!-- ============================================================== -->
<!-- End Left Sidebar - style you can find in sidebar.scss  -->
<!-- ============================================================== -->
</#macro>