package com.engrs.showcase.api.valueAssistance;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(value = "valueassistance", description = "the value assistance API", tags = {"value-assistance-controller"})
public interface ValueAssistanceApi
{
  @ApiOperation(
    value = "Gets value assistance lists by names",
    nickname = "getValueAssistance",
    notes = "Gets all value/label entries of all value assistance with one of the given names",
    response = ValueAssistanceDTO.class)
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Successful operation", response = ValueAssistanceDTO.class),
    @ApiResponse(code = 400, message = "Bad input parameter")})
  @RequestMapping(value = "",
    produces = {"application/json;charset=UTF-8"},
    method = RequestMethod.GET)
  ValueAssistanceDTO getValueAssistance(
          @NotNull
          @ApiParam(value = "Pass the name of one or more value assistance to get the entries", required = true)
          @Valid
          @RequestParam(value = "types", required = true)
                  List<String> types);
}
