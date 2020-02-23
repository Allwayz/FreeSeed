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
            return "StudentPage/studentDashboard";
        }
    },
    Teacher{
        @Override
        public String LoginUrl() {
            return "TeacherPage/teacherDashboard";
        }
    }
}
