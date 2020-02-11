package Repository;

import Domain.Route;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RouteFileRepository {
    private String filename;
    private ArrayList<Route> routes=new ArrayList<>();

    public RouteFileRepository(String filename) {
        this.filename = filename;
        this.readRoutes(filename);
    }

    public ArrayList<Route> getRoutes() {
        return routes;
    }

    public void readRoutes(String filename)
    {
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(filename));
            String line = null;
            while ((line = br.readLine()) != null)
            {
                String[] elems = line.split("-");
                if (elems.length < 7)
                    continue;
                Route b = new Route(Integer.parseInt(elems[0].strip()), elems[1].strip(),elems[2].strip(),elems[3].strip(),elems[4].strip(),
                        Integer.parseInt(elems[5].strip()),Integer.parseInt(elems[6].strip()));
                this.routes.add(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (br != null)
                try {
                    br.close();
                }
                catch (IOException e)
                {
                    System.out.println("Error while closing the file " + e);
                }
        }


    }
}
