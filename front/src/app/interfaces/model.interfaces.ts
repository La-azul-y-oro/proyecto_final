// CLIENT
export interface ClientRequest{
    name: string;
    lastName: string;
    category: DocumentType;
    identificationNumber: number;
    email: string;
    businessName?: string;
}

export interface ClientResponse{
    id: number;
    name: string;
    lastName: string;
    category: DocumentType;
    identificationNumber: number;
    email: string;
    businessName?: string;
    deleted?: boolean;
    //TODO agregar servicios vinculados, cuando esten disponibles
}

export enum DocumentType {
    DNI = 'DNI',
    CUIT = 'CUIT'
}

//VEHICLE
export interface VehicleRequest{
    plate: string;
    brandId: number;
    model: string;
    mileage: number;
    observations: string;
}

export interface VehicleResponse{
    id: number;
    plate: string;
    model: string;
    mileage: number;
    observations: string;
    deleted: boolean;
    brand: BrandResponse;
}

//BRAND
export interface BrandRequest{
    name: string;
    category: BrandCategory;
}

export interface BrandResponse{
    id: number;
    name: string;
    category: BrandCategory;
    deleted: boolean;
}

export enum BrandCategory {
    CAR = 'CAR',
    SPAREPART = 'SPAREPART',
    CAR_AND_SPAREPART = 'CAR_AND_SPAREPART'

}

//SERVICES
export interface ServiceRequest{
    clientId: number;
    vehicleId: number;
    sparePartsIds: number;
    employeesIds: number;
    serviceTypeId: number;
    startDate: Date;
    finalDate: Date;
    status: StatusService;
}

export enum StatusService{
    TO_DO = 'TO_DO', 
    IN_PROGRESS = 'IN_PROGRESS', 
    FINISHED = 'FINISHED', 
    CANCELLED = 'CANCELLED'
}

export interface ServiceResponse{
    id: number;
    serviceType: ServiceTypeResponse;
    status: StatusService;
    payDate: Date;
    price: number;
    startDate: Date;
    finalDate: Date;
    vehicle: VehicleBasicResponse;
    client: ClientBasicResponse;
    employees: EmployeeBasicResponse[];
    spareParts: SparePartResponse[];
    vehicleCompound: string;
    sparePartsCompound: string;
    employeesCompound: string;
    showedStatus: string,
    clientName: string
}

export interface ServiceTypeResponse{
    name: string;
    description: string;
    isDeleted: boolean;
}

export interface VehicleBasicResponse{
    plate: string;
    model: string;
    mileage: number;
    observations: string;
    brand: string;
}

export interface ClientBasicResponse{
    id: number;
    name: string;
    lastName: string;
    category: DocumentType;
    identificationNumber: number;
    email: string;
    businessName?: string;
    deleted?: boolean;
}

export interface SparePartResponse {
    id: number;
    name: string;
    brand: BrandResponse;
    madeIn: string;
    isDeleted: boolean;
}

export interface BrandResponse{
    id: number;
    name: string;
    category: BrandCategory;
    isDeleted: boolean;
}


// EMPLOYEE
export interface EmployeeBasicResponse {
    id: number;
    name: string;
    lastName: string;
    deleted?: boolean;
}

export interface EmployeeResponse {
    id:                   number;
    name:                 string;
    lastName:             string;
    services:             ServiceBasic[];
    email:                string;
    identificationNumber: number;
    role:                 Role;
    roleText:             string;
    address:              Address;
    deleted?:             boolean;
    addressCompound:        string;
}

export interface EmployeeRequest {
    name:                 string;
    lastName:             string;
    email:                string;
    identificationNumber: number;
    role:                 Role;
    address:              Address;
    password:             string;
}

export interface Address {
    street:     string;
    number:     number;
    floor?:      number;
    department?: string;
}

export interface ServiceBasic {
    id:          number;
    serviceType: string;
    status:      string;
    price:       number;
    startDate:   Date;
    vehicle:     VehicleBasicResponse;
    payDate?:    Date;
    finalDate?:  Date;
}

export enum Role {
    ROLE_ADMINISTRATIVE = 'Administrativo',
    ROLE_MECHANIC = 'Mecánico',
    ROLE_ADMIN = 'Admin'
}

export interface EmployeeLogin {
    email:string,
    password:string
}