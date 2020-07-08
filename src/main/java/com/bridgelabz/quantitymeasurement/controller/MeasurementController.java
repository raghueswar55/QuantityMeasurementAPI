package com.bridgelabz.quantitymeasurement.controller;

import com.bridgelabz.quantitymeasurement.enumeration.UnitTypes;
import com.bridgelabz.quantitymeasurement.enumeration.Units;
import com.bridgelabz.quantitymeasurement.model.Quantity;
import com.bridgelabz.quantitymeasurement.scrvice.UnitConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("measurements")
@Api(value = "Measurement conversion controller")
public class MeasurementController {

    @Autowired
    private UnitConverter unitConverter;

    @ApiOperation(value = "returns array of valid unit types ")
    @GetMapping( "/")
    public UnitTypes[] getAllUnitTypes() {
        return unitConverter.getAllUnitTypes();
    }

    @ApiOperation(value = "returns array of valid units of given type ")
    @GetMapping(value = {"/{unitType}"})
    public Units[] getValidUnitsOf(@PathVariable("unitType") UnitTypes unitType) {
        return unitConverter.getValidUnitsOf(unitType);
    }

    @ApiOperation(value = "converts value to given unit ", notes = "to convert 10inch to feet example path variables INCH/10/FEET")
    @GetMapping("convert/{oldUnit}/{value}/{newUnit}")
    public Quantity convertUnits(@PathVariable("oldUnit") Units  oldUnit, @PathVariable("value") double value,
                                 @PathVariable("newUnit") Units  newUnit) {
        return unitConverter.convert(new Quantity(value, oldUnit), newUnit);
    }

}
