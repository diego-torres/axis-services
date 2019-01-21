<#macro nav>
    <!-- ============================================================== -->
    <!-- Preloader - style you can find in spinners.css -->
    <!-- ============================================================== -->
    <div class="preloader">
        <div class="loader">
            <div class="loader__figure"></div>
            <p class="loader__label">Axis BPS</p>
        </div>
    </div>
    <div style="display:none">
    <form name="logoutForm" id="logoutForm" action="<@spring.url '/sso/logout' />" method="post">
        <input type="hidden"
            name="${_csrf.parameterName}"
            value="${_csrf.token}"/>
        <input type="submit" name="btnSubmit" value="Logout"/>
    </form>
    </div>
</#macro>