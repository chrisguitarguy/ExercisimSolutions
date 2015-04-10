<?php

function distance($a, $b)
{
    if (strlen($a) !== strlen($b)) {
        throw new \InvalidArgumentException('DNA strands must be of equal length.');
    }

    $distance = 0;
    $len = strlen($a);
    for ($i = 0; $i < $len; $i++) {
        if ($a[$i] !== $b[$i]) {
            $distance++;
        }
    }

    return $distance;
}
