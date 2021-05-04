import car.Car;
import car.CarGroup;
import util.ListUtils;
import view.dto.CarGroupPositionDto;
import view.dto.CarPositionDto;

public class RacingCarDtoConverter {
	static CarGroupPositionDto toCarGroupPositionDto(CarGroup carGroup) {
		return new CarGroupPositionDto(ListUtils.map(carGroup.getCars(), RacingCarDtoConverter::toCarPositionDto));
	}

	private static CarPositionDto toCarPositionDto(Car car) {
		return new CarPositionDto(car.getName(), car.getPosition());
	}
}
