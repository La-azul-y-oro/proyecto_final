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
    isDeleted: boolean;
    // TODO brandDto: BrandResponse
}
