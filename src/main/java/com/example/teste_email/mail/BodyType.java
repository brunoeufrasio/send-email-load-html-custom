package com.example.teste_email.mail;


import lombok.extern.slf4j.Slf4j;
import lombok.Getter;


@Slf4j
@Getter
public enum BodyType {
    RESET_PASSWORD("reset-password"), NEW_IMPEDIMENT("new-impediment"),
    EMPLOYEE_ADDIO_THE_TASK("employee-addio-the-task"),
    EMPLOYEE_ADDIO_THE_ACTION_PLAN("employee-addio-the-action-plan"),
    EMPLOYEE_REMOVED_THE_TASK("employee-removed-the-task"),
    EMPLOYEE_REMOVED_THE_ACTION_PLAN("employee-removed-the-action-plan"),
    NEW_TASK_IMPEDIMENT("new-task-impediment"),
    NEW_ACTION_PLAN_IMPEDIMENT("new-action-plan-impediment"),
    CONCLUDE_TASK_IMPEDIMENT("conclude-task-impediment"),
    CONCLUDE_ACTION_PLAN_IMPEDIMENT("conclude-action-plan-impediment"),
    PENDING_ACTION_PLAN_IMPEDIMENT("pending-action-plan-impediment"),
    PENDING_TASK_IMPEDIMENT("pending-task-impediment"), WELCOME("welcome");

    private String name;

    BodyType(final String name) {
        this.name = name;
    }

    public static BodyType of(final String value) {

        try {
            return valueOf(value);
        } catch (Exception e) {
       //     log.error("Os tipos válidos são: " + Arrays
          //                      .asList(BodyType.values()).stream().map(s -> s.getName()).collect(Collectors.toList()).toString(), HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}