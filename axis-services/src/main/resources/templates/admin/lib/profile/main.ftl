<#import "comment.ftl" as comment />
<#import "messages.ftl" as messages />
<#import "megamenu.ftl" as megamenu />
<#import "user.ftl" as user />
<#macro nav>
<!-- ============================================================== -->
<!-- User profile and search -->
<!-- ============================================================== -->
<ul class="navbar-nav my-lg-0">
    <@comment.nav />
    <@messages.nav />
    <@megamenu.nav />
    <@user.nav />
    <li class="nav-item right-side-toggle"> <a class="nav-link  waves-effect waves-light" href="javascript:void(0)"><i class="ti-settings"></i></a></li>
</ul>
</#macro>