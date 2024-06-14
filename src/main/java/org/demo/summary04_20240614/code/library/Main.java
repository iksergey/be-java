package org.demo.summary04_20240614.code.library;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository();
        System.out.println(repository);
        Model m1 = new Model(1, "model 1");
        Model m2 = new Model(2, "model 2");
        repository.append(m1);
        // repository.append(1, "model 1");
        // repository.append(2, "model 2");
        System.out.println(repository);

        Model gm = repository.get(0);
        System.out.println(gm);

        gm.setName("НОВОЕ ИМЯ");
        m1.setName("НОВОЕ ИМЯ");
        System.out.println(repository);
        System.out.println(gm);
        System.out.println(m2);

    }
}

@Data
@AllArgsConstructor
class Model {
    private int id;
    private String name;
}

class Repository {
    List<Model> db = new ArrayList<>();

    public void append(Model model) {
        db.add(new Model(model.getId(), model.getName()));
    }

    public void append(int id, String name) {
        db.add(new Model(id, name));
    }

    public Model get(int index) {
        if (!(index >= 0 && index <= db.size()))
            return null;
        Model m = db.get(index);

        return new Model(m.getId(), m.getName());
    }

    @Override
    public String toString() {
        return db.toString();
    }
}
