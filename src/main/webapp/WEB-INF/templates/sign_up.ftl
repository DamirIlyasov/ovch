<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<@sf.form action="/sign_up" method="post" modelAttribute="user">
    <fieldset>
        <div>
            <@sf.label path="firstName">Firstname</@sf.label>
            <@sf.input path="firstName" type="firstName"/>
            <@sf.errors path="firstName"/>
        </div>
        <div>
            <@sf.label path="lastName">Lastname</@sf.label>
            <@sf.input path="lastName" type="lastName"/>
            <@sf.errors path="lastName"/>
        </div>
        <div>
            <@sf.label path="phone">phone</@sf.label>
            <@sf.input path="phone" type="phone"/>
            <@sf.errors path="phone"/>
        </div>
        <div>
            <@sf.label path="age">Age</@sf.label>
            <@sf.input path="age" type="age"/>
            <@sf.errors path="age"/>
        </div>
        <div>
            <@sf.label path="email">Email</@sf.label>
            <@sf.input path="email" type="email"/>
            <@sf.errors path="email"/>
        </div>
        <div>
            <@sf.label path="password">Password</@sf.label>
            <@sf.input path="password" type="password"/>
            <@sf.errors path="password"/>
        </div>
        <div>
            <input type="submit" value="Sign up">
        </div>
    </fieldset>
</@sf.form>
<@sf.form action="/sign_in" method = "get">
    <button type="submit">Sign in</button>
</@sf.form>