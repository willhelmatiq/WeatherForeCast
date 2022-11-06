package space.harbour.weatherforecast.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    private String[] capital;
    private CapitalInfo capitalInfo;
}
