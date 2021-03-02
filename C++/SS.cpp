#include "SS.h"

SelectionSort::SelectionSort() {}

void SelectionSort::sort(Container* container) {
        for(int i = 0; i < container->size() - 1; ++i) {
                int min = i;
                for(int j = i + 1; j < container->size(); ++j) {
                        if(container->at(j)->evaluate() < container->at(min)->evaluate()) {
                                min = j;
                        }
}
container->swap(min, i);
}
}
