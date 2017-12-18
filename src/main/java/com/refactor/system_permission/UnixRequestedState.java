package com.refactor.system_permission;

public class UnixRequestedState extends AbstractPermissionState {
    public UnixRequestedState(SystemPermission systemPermission) {
        super(systemPermission);
    }

    @Override
    public void claimBy(SystemAdmin admin) {
        systemPermission.setAdmin(admin);
        systemPermission.setPermissionState(new UnixClaimedSate(systemPermission));
    }

    @Override
    public void denyBy(SystemAdmin admin) {

    }

    @Override
    public void grantBy(SystemAdmin admin) {

    }

    @Override
    public String getState() {
        return SystemPermission.UNIX_REQUESTED;
    }
}
