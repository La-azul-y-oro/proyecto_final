export const hasValidRoles = (employeeData : any, roles : string[]) => { 
    return roles.includes(employeeData?.role);
}