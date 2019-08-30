$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/Login.feature");
formatter.feature({
  "name": "Open Source CMS login cases",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": ": Test Login functionality with valid data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@SmokeT321est"
    }
  ]
});
formatter.step({
  "name": "Browser and login page is opened",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDefinition.Browser_and_login_page_is_opened()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter valid uesrname and valid password",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ]
    },
    {
      "cells": [
        "xyz",
        "abc"
      ]
    },
    {
      "cells": [
        "asd",
        "opensourcecms"
      ]
    },
    {
      "cells": [
        "opensourcecms",
        "kmdns"
      ]
    },
    {
      "cells": [
        "opensourcecms",
        "opensourcecms"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDefinition.Enter_valid_uesrname_and_valid_password(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should be able to login successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinition.user_should_be_able_to_login_successfully()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinition.close_the_browser()"
});
formatter.result({
  "status": "passed"
});
});