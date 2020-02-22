package com.allwayz.freeseed.model.enums;

public enum RoleEnum implements roleOperation {
    admin{
        @Override
        public String LoginUrl() {
            return "dashboard";
        }
    },

    student{
        @Override
        public String LoginUrl() {
            return "personalIndex";
        }
    },
    Teacher{
        @Override
        public String LoginUrl() {
            return "teacherPage";
        }
    }
}
