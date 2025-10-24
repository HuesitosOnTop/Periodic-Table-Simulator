package Handlers;

public class Element {
    private String state_at_room_temp = "Solid";
    private String atomic_name = "";
    private String group = "nonmetal";
    private String electron_configuration = "";
    private int[] oxidation_states = {};
    private int year_discovered = 1;
    private int atomic_number = 1;
    private double electronegativity = 0.0;
    private double ionization_energy = 0.0;
    private double electron_affinity = 0.0;
    private double melting_point = 0.0;
    private double boiling_point = 0.0;
    private double atomic_density = 0.0;
    private double atomic_mass = 0.0;

    public Element(String[] data, int[] oxi_states) {
        state_at_room_temp     = data[0];
        atomic_name            = data[1];
        group                  = data[2];
        electron_configuration = data[3];
        oxidation_states       = oxi_states;
        year_discovered        = Integer.parseInt(data[4]);
        atomic_number          = Integer.parseInt(data[5]);
        electronegativity      = Double.parseDouble(data[6]);
        ionization_energy      = Double.parseDouble(data[7]);
        electron_affinity      = Double.parseDouble(data[8]);
        melting_point          = Double.parseDouble(data[9]);
        boiling_point          = Double.parseDouble(data[10]);
        atomic_density         = Double.parseDouble(data[11]);
        atomic_density         = Double.parseDouble(data[12]);
    }
}
