export const hasValidRoles = (employeeData : any, roles : string[]) => {
    const userInfo = employeeData as any;
    const role = userInfo?.role
  
    return roles.includes(role);
}