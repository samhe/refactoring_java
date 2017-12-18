package com.refactor.system_permission;

public class GrantedState extends AbstractPermissionState {
    public GrantedState(SystemPermission systemPermission) {
        super(systemPermission);
    }

    @Override
    public void claimBy(SystemAdmin admin) {

    }

    @Override
    public void denyBy(SystemAdmin admin) {

    }


    @Override
    public void grantBy(SystemAdmin admin) {

    }

    @Override
    public String getState() {
        return SystemPermission.GRANTED;
    }
}
