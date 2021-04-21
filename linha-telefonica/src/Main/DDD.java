/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author RGrupos
 */
public class DDD {

    private int[] result = {
        11,
        12,
        13,
        14,
        15,
        16,
        17,
        18,
        19,
        21,
        22,
        24,
        27,
        28,
        31,
        32,
        33,
        34,
        35,
        37,
        38,
        41,
        42,
        43,
        44,
        45,
        46,
        47,
        48,
        49,
        51,
        53,
        54,
        55,
        61,
        62,
        63,
        64,
        65,
        66,
        67,
        68,
        69,
        71,
        73,
        74,
        75,
        77,
        79,
        81,
        82,
        83,
        84,
        85,
        86,
        87,
        88,
        89,
        91,
        92,
        93,
        94,
        95,
        96,
        97,
        98,
        99
    };

    public Coordinates getCoordinate(int pos) {
        Coordinates[] dddGeo = new Coordinates[100];

        //DDDs
        dddGeo[11] = new Coordinates(-23.547778, -46.635833);
        dddGeo[12] = new Coordinates(-23.203416, -45.890627);
        dddGeo[13] = new Coordinates(-23.960833, -46.333889);
        dddGeo[14] = new Coordinates(-23.547778, -46.633309);
        dddGeo[15] = new Coordinates(-23.497741, -47.457983);
        dddGeo[16] = new Coordinates(-21.170401, -47.810324);
        dddGeo[17] = new Coordinates(-20.800433, -49.365853);
        dddGeo[18] = new Coordinates(-23.55052, -46.633309);
        dddGeo[19] = new Coordinates(-22.905833, -47.060833);
        dddGeo[22] = new Coordinates(-21.735556, -41.333019);
        dddGeo[21] = new Coordinates(-22.9028, -43.2078);
        dddGeo[24] = new Coordinates(-22.906847, -43.172896);
        dddGeo[27] = new Coordinates(-20.3189, -40.3378);
        dddGeo[28] = new Coordinates(-20.846705, -41.12022);
        dddGeo[31] = new Coordinates(-19.916667, -43.933333);
        dddGeo[32] = new Coordinates(-21.761044, -43.347797);
        dddGeo[33] = new Coordinates(-18.85892, -41.943214);
        dddGeo[35] = new Coordinates(-18.512178, -44.555031);
        dddGeo[37] = new Coordinates(-18.512178, -44.555031);
        dddGeo[38] = new Coordinates(-16.729319, 43.867126);
        dddGeo[41] = new Coordinates(-25.4297, -49.2719);
        dddGeo[42] = new Coordinates(-24.949608, -53.422725);
        dddGeo[43] = new Coordinates(-23.309641, -51.148806);
        dddGeo[44] = new Coordinates(-23.450343, -51.863671);
        dddGeo[45] = new Coordinates(-24.953015, -53.452892);
        dddGeo[46] = new Coordinates(-26.22972, -52.671136);
        dddGeo[47] = new Coordinates(-27.242339, -50.218856);
        dddGeo[48] = new Coordinates(-27.597022, -48.549583);
        dddGeo[49] = new Coordinates(-27.242339, -50.218856);
        dddGeo[51] = new Coordinates(-30.034647, -51.217658);
        dddGeo[53] = new Coordinates(-31.767898, -52.337498);
        dddGeo[54] = new Coordinates(-29.179124, -51.149251);
        dddGeo[55] = new Coordinates(-29.691483, -53.792261);
        dddGeo[61] = new Coordinates(-15.688838, -47.817738);
        dddGeo[62] = new Coordinates(-16.666667, -49.25);
        dddGeo[63] = new Coordinates(-10.17528, -48.298247);
        dddGeo[64] = new Coordinates(-17.789523, -50.920427);
        dddGeo[65] = new Coordinates(-15.601411, -56.097892);
        dddGeo[66] = new Coordinates(-12.681871, -56.921099);
        dddGeo[67] = new Coordinates(-12.6818718, -56.921099);
        dddGeo[68] = new Coordinates(-9.023796, -70.811995);
        dddGeo[69] = new Coordinates(-11.505734, -63.580611);
        dddGeo[71] = new Coordinates(-12.970833, -38.51083);
        dddGeo[73] = new Coordinates(-14.788033, -39.278418);
        dddGeo[74] = new Coordinates(-9.418046, -40.501062);
        dddGeo[75] = new Coordinates(-12.232754, -38.949572);
        dddGeo[77] = new Coordinates(-14.861924, -40.844535);
        dddGeo[79] = new Coordinates(-10.574093, -37.385658);
        dddGeo[81] = new Coordinates(-8.057838, -34.882897);
        dddGeo[82] = new Coordinates(-9.571306, -36.78195);
        dddGeo[83] = new Coordinates(-7.239961, -36.78195);
        dddGeo[84] = new Coordinates(-5.40258, -36.954107);
        dddGeo[85] = new Coordinates(-3.78, -38.59);
        dddGeo[86] = new Coordinates(-5.098041, -42.758734);
        dddGeo[87] = new Coordinates(-9.377469, -40.535025);
        dddGeo[88] = new Coordinates(-7.229036, -39.312446);
        dddGeo[89] = new Coordinates(-6.776932, -43.022602);
        dddGeo[91] = new Coordinates(-1.455833, -48.503889);
        dddGeo[92] = new Coordinates(-3.079587, -60.067331);
        dddGeo[93] = new Coordinates(-2.450629, -54.700923);
        dddGeo[94] = new Coordinates(-5.381136, -49.133102);
        dddGeo[95] = new Coordinates(2.737597, -62.0751);
        dddGeo[96] = new Coordinates(2.04474, -50.787422);
        dddGeo[97] = new Coordinates(-4.09449, -63.14461);
        dddGeo[98] = new Coordinates(-2.53, -44.302778);
        dddGeo[99] = new Coordinates(-5.522392, -47.495684);
        return dddGeo[pos];
    }

    public Boolean available(int val) {
        Boolean answer = false;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == val) {
                answer = true;
            }
        }
        return answer;
    }

    public int[] getDDDs() {
        return result;
    }

}
